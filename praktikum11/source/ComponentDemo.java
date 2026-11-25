import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ComponentDemo extends JFrame {
    public ComponentDemo() {
        super("Swing Component Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nameField = new JTextField(15);
        JComboBox<String> deptCombo = new JComboBox<>(
                new String[] {"Informatika", "Elektronika", "Mesin"});
        JCheckBox activeCheck = new JCheckBox("Mahasiswa aktif", true);

        JRadioButton regulerRadio = new JRadioButton("Reguler", true);
        JRadioButton ekstensiRadio = new JRadioButton("Ekstensi");
        ButtonGroup classGroup = new ButtonGroup();
        classGroup.add(regulerRadio);
        classGroup.add(ekstensiRadio);

        JTextArea outputArea = new JTextArea(6, 25);
        outputArea.setEditable(false);
        JButton showButton = new JButton("Tampilkan");

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 8, 8));
        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setLabelFor(nameField);
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        JLabel deptLabel = new JLabel("Jurusan:");
        deptLabel.setLabelFor(deptCombo);
        formPanel.add(deptLabel);
        formPanel.add(deptCombo);

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        optionsPanel.add(activeCheck);
        optionsPanel.add(regulerRadio);
        optionsPanel.add(ekstensiRadio);

        JPanel inputPanel = new JPanel(new BorderLayout(0, 4));
        inputPanel.add(formPanel, BorderLayout.NORTH);
        inputPanel.add(optionsPanel, BorderLayout.SOUTH);

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        actionPanel.add(showButton);

        JPanel content = new JPanel(new BorderLayout(0, 8));
        content.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        content.add(inputPanel, BorderLayout.NORTH);
        content.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        content.add(actionPanel, BorderLayout.SOUTH);
        setContentPane(content);

        showButton.addActionListener(event -> {
            String name = nameField.getText().strip();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama wajib diisi.",
                        "Input tidak valid", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String kelas = regulerRadio.isSelected() ? "Reguler" : "Ekstensi";
            outputArea.setText("Nama: " + name
                    + "\nJurusan: " + deptCombo.getSelectedItem()
                    + "\nAktif: " + activeCheck.isSelected()
                    + "\nKelas: " + kelas);
        });

        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ComponentDemo().setVisible(true));
    }
}
