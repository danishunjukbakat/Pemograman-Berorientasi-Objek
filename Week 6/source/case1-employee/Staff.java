import java.util.Locale;

public class Staff {
    private StaffMember[] staffList;

    public Staff() { this(true); }

    // false dipakai hanya untuk eksperimen baseline enam staff.
    public Staff(boolean includeCommission) {
        staffList = new StaffMember[includeCommission ? 8 : 6];
        Executive leader = new Executive("Andi", "Bandung", "000-01",
                "DEMO-01", 2423.07);
        leader.awardBonus(500);
        staffList[0] = leader;
        staffList[1] = new Employee("Budi", "Bandung", "000-02",
                "DEMO-02", 1246.15);
        staffList[2] = new Employee("Citra", "Bandung", "000-03",
                "DEMO-03", 1169.23);
        Hourly worker = new Hourly("Dedi", "Bandung", "000-04",
                "DEMO-04", 10.55);
        worker.addHours(40);
        staffList[3] = worker;
        staffList[4] = new Volunteer("Eka", "Bandung", "000-05");
        staffList[5] = new Volunteer("Fani", "Bandung", "000-06");

        if (includeCommission) {
            Commission c1 = new Commission("Gita", "Bandung", "000-07",
                    "DEMO-07", 6.25, 0.20);
            c1.addHours(35);
            c1.addSales(400);
            staffList[6] = c1;

            Commission c2 = new Commission("Hadi", "Bandung", "000-08",
                    "DEMO-08", 9.75, 0.15);
            c2.addHours(40);
            c2.addSales(950);
            staffList[7] = c2;
        }
    }

    public void payday() {
        for (int count = 0; count < staffList.length; count++) {
            System.out.println(staffList[count]);
            double amount = staffList[count].pay();
            System.out.printf(Locale.US, "Paid: %.2f%n", amount);
            System.out.println("--------------------");
        }
    }
}
