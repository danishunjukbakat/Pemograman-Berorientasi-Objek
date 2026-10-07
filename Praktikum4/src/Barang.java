public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private String status;

    public Barang(String kodeBarang, String namaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.status = "BAGUS";
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getStatus() {
        return status;
    }

    public void tandaiRusak() {
        status = "RUSAK";
    }

    public void tandaiHilang() {
        status = "HILANG";
    }

    public void perbaiki() {
        if (status == "RUSAK") {
            status = "BAGUS";
        }
    }

    public void tampilkanInfo() {
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Status: " + status);
    }
}