public class BarangFurnitur extends Barang {
    private String bahan;

    public BarangFurnitur(String kodeBarang, String namaBarang, String bahan) {
        super(kodeBarang, namaBarang);
        this.bahan = bahan;
    }

    public String getBahan() {
        return bahan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bahan: " + bahan);
    }
}