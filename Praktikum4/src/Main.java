public class Main {
    public static void main(String[] args) {

        BarangElektronik barang1 =
                new BarangElektronik("BRG001", "Laptop", 65);

        BarangFurnitur barang2 =
                new BarangFurnitur("BRG002", "Meja Belajar", "Kayu");

        Lokasi lokasi1 =
                new Lokasi("LOK001", "Lab Komputer");

        Lokasi lokasi2 =
                new Lokasi("LOK002", "Ruang Kelas");

        PencatatanInventaris catatan1 =
                new PencatatanInventaris(
                        "INV001",
                        barang1,
                        lokasi1
                );

        PencatatanInventaris catatan2 =
                new PencatatanInventaris(
                        "INV002",
                        barang2,
                        lokasi2
                );

        System.out.println("DATA INVENTARIS BARANG KAMPUS");

        System.out.println("\n=== DATA INVENTARIS 1 ===");
        catatan1.tampilkanData();

        System.out.println("\n=== DATA INVENTARIS 2 ===");
        catatan2.tampilkanData();

        System.out.println("\n=== STATUS SEBELUM BEHAVIOR ===");

        System.out.println(
                barang1.getNamaBarang()
                        + ": "
                        + barang1.getStatus()
        );

        System.out.println(
                barang2.getNamaBarang()
                        + ": "
                        + barang2.getStatus()
        );

        barang1.tandaiRusak();
        barang2.tandaiHilang();

        System.out.println("\n=== STATUS SETELAH BEHAVIOR ===");

        System.out.println(
                barang1.getNamaBarang()
                        + ": "
                        + barang1.getStatus()
        );

        System.out.println(
                barang2.getNamaBarang()
                        + ": "
                        + barang2.getStatus()
        );

        barang1.perbaiki();

        System.out.println("\n=== STATUS SETELAH PERBAIKAN ===");

        System.out.println(
                barang1.getNamaBarang()
                        + ": "
                        + barang1.getStatus()
        );

        System.out.println(
                barang2.getNamaBarang()
                        + ": "
                        + barang2.getStatus()
        );
    }
}