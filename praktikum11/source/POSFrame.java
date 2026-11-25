import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class POSFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int RUPIAH_PER_POINT = 1_000;

    private final List<Product> products = List.of(
        new Product("P001", "Air Mineral 600ml", 3_000),
        new Product("P002", "Kopi Sachet", 5_000),
        new Product("P003", "Roti isi", 8_000),
        new Product("P004", "Snack Keripik", 6_000),
        new Product("P005", "Minuman Botol", 12_000)
    );
    private final List<CartItem> cart = new ArrayList<>();
    private final NumberFormat rupiahDigits =
        NumberFormat.getIntegerInstance(Locale.forLanguageTag("id-ID"));

    private final DefaultTableModel productModel =
        readOnlyModel("ID", "Nama Produk", "Harga (Rp)");
    private final DefaultTableModel cartModel =
        readOnlyModel("ID", "Nama Produk", "Qty", "Subtotal (Rp)");
    private final JTable productTable = new JTable(productModel);
    private final JTable cartTable = new JTable(cartModel);
    private final JTextField qtyField = new JTextField("1", 5);
    private final JLabel selectedLabel = new JLabel("Dipilih: belum ada produk");
    private final JLabel totalLabel = new JLabel();
    private final JLabel pointsLabel = new JLabel();
    private final JTextArea receiptArea = new JTextArea(13, 30);
    private final JButton addButton = new JButton("Add to Cart");
    private final JButton checkoutButton = new JButton("Checkout");
    private final JButton printButton = new JButton("Cetak");

    public POSFrame() {
        super("POIN Off-Sales - Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setJMenuBar(buildMenuBar());

        for (Product product : products) {
            productModel.addRow(new Object[] {
                product.getId(), product.getName(), rupiahDigits.format(product.getPrice())
            });
        }

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(buildProductPanel());
        mainPanel.add(buildCartPanel());
        add(mainPanel, BorderLayout.CENTER);

        bindEvents();
        updateSummary();
        setMinimumSize(new Dimension(800, 540));
        setSize(1000, 650);
        setLocationRelativeTo(null);
    }

    private JMenuBar buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem aboutItem = new JMenuItem("About");

        exitItem.addActionListener(event -> dispose());
        aboutItem.addActionListener(event -> JOptionPane.showMessageDialog(
            this, "POIN Off-Sales - Praktikum Java Swing", "About", JOptionPane.INFORMATION_MESSAGE
        ));

        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }

    private JPanel buildProductPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 6));
        panel.setBorder(BorderFactory.createTitledBorder("Produk"));
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productTable.setRowHeight(23);
        productTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        productTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        productTable.getColumnModel().getColumn(2).setPreferredWidth(95);
        panel.add(new JScrollPane(productTable), BorderLayout.CENTER);

        JPanel productControls = new JPanel(new BorderLayout());
        productControls.add(selectedLabel, BorderLayout.NORTH);
        JPanel qtyControls = new JPanel(new FlowLayout(FlowLayout.LEADING, 6, 4));
        JLabel qtyLabel = new JLabel("Qty:");
        qtyLabel.setLabelFor(qtyField);
        qtyControls.add(qtyLabel);
        qtyControls.add(qtyField);
        qtyControls.add(addButton);
        productControls.add(qtyControls, BorderLayout.SOUTH);
        panel.add(productControls, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buildCartPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 6));
        panel.setBorder(BorderFactory.createTitledBorder("Keranjang"));
        cartTable.setRowHeight(23);
        cartTable.getColumnModel().getColumn(0).setPreferredWidth(45);
        cartTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        cartTable.getColumnModel().getColumn(2).setPreferredWidth(52);
        cartTable.getColumnModel().getColumn(3).setPreferredWidth(140);
        panel.add(new JScrollPane(cartTable), BorderLayout.CENTER);

        JPanel summary = new JPanel(new FlowLayout(FlowLayout.LEADING, 12, 4));
        summary.add(totalLabel);
        summary.add(pointsLabel);
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.TRAILING, 6, 4));
        actions.add(checkoutButton);
        actions.add(printButton);

        receiptArea.setEditable(false);
        receiptArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane receiptScroll = new JScrollPane(receiptArea);
        receiptScroll.setBorder(BorderFactory.createTitledBorder("Struk"));

        JPanel checkoutPanel = new JPanel(new BorderLayout(0, 4));
        checkoutPanel.add(summary, BorderLayout.NORTH);
        checkoutPanel.add(receiptScroll, BorderLayout.CENTER);
        checkoutPanel.add(actions, BorderLayout.SOUTH);
        panel.add(checkoutPanel, BorderLayout.SOUTH);
        return panel;
    }

    private void bindEvents() {
        productTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                Product product = getSelectedProduct();
                if (product == null) {
                    selectedLabel.setText("Dipilih: belum ada produk");
                } else {
                    selectedLabel.setText(
                        "Dipilih: " + product + " (" + formatRupiah(product.getPrice()) + ")"
                    );
                }
            }
        });
        addButton.addActionListener(event -> addSelectedProductToCart());
        checkoutButton.addActionListener(event -> checkout());
        printButton.addActionListener(event -> printReceipt());
    }

    private Product getSelectedProduct() {
        int row = productTable.getSelectedRow();
        return row < 0 ? null : products.get(productTable.convertRowIndexToModel(row));
    }

    private void addSelectedProductToCart() {
        Product product = getSelectedProduct();
        if (product == null) {
            showWarning("Pilih produk terlebih dahulu.");
            return;
        }

        try {
            int qty = Integer.parseInt(qtyField.getText().strip());
            cart.add(new CartItem(product, qty));
        } catch (IllegalArgumentException ex) {
            showWarning("Qty harus berupa bilangan bulat lebih dari 0.");
            return;
        }

        refreshCartTable();
        updateSummary();
    }

    private void refreshCartTable() {
        cartModel.setRowCount(0);
        for (CartItem item : cart) {
            Product product = item.getProduct();
            cartModel.addRow(new Object[] {
                product.getId(), product.getName(), item.getQty(),
                rupiahDigits.format(item.getSubtotal())
            });
        }
    }

    private long getCartTotal() {
        return cart.stream().mapToLong(CartItem::getSubtotal).sum();
    }

    private void updateSummary() {
        long total = getCartTotal();
        totalLabel.setText("Total: " + formatRupiah(total));
        pointsLabel.setText("Points: " + total / RUPIAH_PER_POINT);
    }

    private void checkout() {
        if (cart.isEmpty()) {
            showWarning("Keranjang masih kosong.");
            return;
        }

        StringBuilder receipt = new StringBuilder();
        receipt.append("===== POIN OFF-SALES =====\n");
        receipt.append("Toko: Demo Toko\n");
        receipt.append("==========================\n");
        for (CartItem item : cart) {
            receipt.append(item.getProduct().getName())
                .append(" x ").append(item.getQty())
                .append(" = ").append(formatRupiah(item.getSubtotal())).append('\n');
        }
        long total = getCartTotal();
        receipt.append("--------------------------\n");
        receipt.append("Total: ").append(formatRupiah(total)).append('\n');
        receipt.append("Points: ").append(total / RUPIAH_PER_POINT).append('\n');
        receipt.append("Terima kasih!");
        receiptArea.setText(receipt.toString());
        receiptArea.setCaretPosition(0);

        cart.clear();
        refreshCartTable();
        updateSummary();
    }

    private void printReceipt() {
        if (receiptArea.getText().isBlank()) {
            showWarning("Belum ada struk yang dapat dicetak.");
            return;
        }

        try {
            receiptArea.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(
                this, "Gagal mencetak: " + ex.getMessage(), "Gagal mencetak", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showWarning(String message) {
        JOptionPane.showMessageDialog(this, message, "Peringatan", JOptionPane.WARNING_MESSAGE);
    }

    private String formatRupiah(long amount) {
        return "Rp" + rupiahDigits.format(amount);
    }

    private static DefaultTableModel readOnlyModel(String... columns) {
        return new DefaultTableModel(columns, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
