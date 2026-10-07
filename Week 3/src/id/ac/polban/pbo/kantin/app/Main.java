package id.ac.polban.pbo.kantin.app;

import id.ac.polban.pbo.kantin.model.Mahasiswa;
import id.ac.polban.pbo.kantin.model.MenuItem;
import id.ac.polban.pbo.kantin.model.Pesanan;

public class Main {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("251511012", "Faza");
        Mahasiswa m2 = new Mahasiswa("251511007", "Danish");

        MenuItem nasi = new MenuItem("M01", "Nasi Goreng", 18000);
        MenuItem kopi = new MenuItem("M02", "Kopi Susu", 12000);

        kopi.tandaiHabis();

        Pesanan p1 = new Pesanan(m1, nasi, 2);
        Pesanan p2 = new Pesanan(m2, kopi, 1);
        Pesanan p3 = new Pesanan(m1, nasi, 1);
        Pesanan p4 = new Pesanan(m1, nasi, 0);  

        System.out.println(p1.ringkasan());
        System.out.println(p2.ringkasan());
        System.out.println(p3.ringkasan());
        System.out.println("P4 dapat diproses: " + p4.dapatDiproses());
        System.out.println("Jumlah pesanan dibuat: " + Pesanan.getJumlahPesananDibuat());
    }
}