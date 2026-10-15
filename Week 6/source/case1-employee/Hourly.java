public class Hourly extends Employee {
    private int hoursWorked;

    public Hourly(String name, String address, String phone,
                  String ssn, double rate) {
        super(name, address, phone, ssn, rate);
    }

    public void addHours(int hours) { hoursWorked += hours; }

    @Override
    public double pay() {
        double payment = payRate * hoursWorked;
        hoursWorked = 0;
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHours: " + hoursWorked;
    }
}
