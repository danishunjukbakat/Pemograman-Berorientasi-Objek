public class PencatatanInventaris {
    private String kodePencatatan;
    private Barang barang;
    private Lokasi lokasi;

    public PencatatanInventaris(
            String kodePencatatan,
            Barang barang,
            Lokasi lokasi) {

        this.kodePencatatan = kodePencatatan;
        this.barang = barang;
        this.lokasi = lokasi;
    }

    public String getKodePencatatan() {
        return kodePencatatan;
    }

    public Barang getBarang() {
        return barang;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void tampilkanData() {
        System.out.println("Kode Pencatatan: " + kodePencatatan);

        barang.tampilkanInfo();

        System.out.println("Kode Lokasi: " + lokasi.getKodeLokasi());
        System.out.println("Nama Lokasi: " + lokasi.getNamaLokasi());
    }
}