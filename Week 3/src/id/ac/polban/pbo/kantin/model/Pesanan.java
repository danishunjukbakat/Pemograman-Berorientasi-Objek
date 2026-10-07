package id.ac.polban.pbo.kantin.model;

public class Pesanan {
    
    private static int nextNumber = 1;
    private static int jumlahPesananDibuat = 0;

    private int nomor;
    private Mahasiswa pemesan;
    private MenuItem menu;
    private int jumlah;

    public Pesanan(Mahasiswa pemesan, MenuItem menu, int jumlah) {
        this.nomor = nextNumber++;
        this.pemesan = pemesan;
        this.menu = menu;
        this.jumlah = jumlah;
        jumlahPesananDibuat++;
    }

    public int getNomor() {
        return nomor;
    }

    public boolean dapatDiproses() {
        return jumlah > 0 && menu.isTersedia();
    }

    public int hitungTotal() {
        return menu.getHarga() * jumlah;
    }

    public String ringkasan() {
        return "Pesanan #" + nomor
                + " | " + pemesan.getNama()
                + " | " + menu.getNama()
                + " | Jumlah: " + jumlah
                + " | Total: Rp" + hitungTotal();
    }

    public static int getJumlahPesananDibuat() {
        return jumlahPesananDibuat;
    }
}