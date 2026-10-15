public class Firm {
    public static void main(String[] args) {
        boolean baseline = args.length > 0 && args[0].equals("baseline");
        Staff personnel = new Staff(!baseline);
        System.out.println(baseline ? "BASELINE 6 STAFF" : "PAYROLL 8 STAFF");
        personnel.payday();
        if (args.length > 0 && args[0].equals("twice")) {
            System.out.println("PAYROLL KEDUA TANPA TAMBAHAN JAM ATAU SALES");
            personnel.payday();
        }
    }
}
