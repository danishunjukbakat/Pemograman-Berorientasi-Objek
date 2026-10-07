public class Lokasi {
    private String kodeLokasi;
    private String namaLokasi;

    // Constructor
    public Lokasi(String kodeLokasi, String namaLokasi) {
        this.kodeLokasi = kodeLokasi;
        this.namaLokasi = namaLokasi;
    }

    // Getter
    public String getKodeLokasi() {
        return kodeLokasi;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }
}