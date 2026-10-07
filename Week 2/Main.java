public class Barang {

    private String namaBarang;
    private String kodeBarang;
    private int jumlah;

    public Barang(String namaBarang, String kodeBarang, int jumlah) {
        this.namaBarang = namaBarang;
        this.kodeBarang = kodeBarang;
        this.jumlah = jumlah;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void pinjamBarang() {
        if (jumlah > 0) {
            jumlah--;
            System.out.println("Barang berhasil dipinjam.");
        } else {
            System.out.println("Barang tidak tersedia.");
        }
    }

    public void tampilkanData() {
        System.out.println("Nama Barang : " + namaBarang);
        System.out.println("Kode Barang : " + kodeBarang);
        System.out.println("Jumlah      : " + jumlah);
    }
}