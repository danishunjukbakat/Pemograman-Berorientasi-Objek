public class Executive extends Employee {
    private double bonus;

    public Executive(String name, String address, String phone,
                     String ssn, double rate) {
        super(name, address, phone, ssn, rate);
    }

    public void awardBonus(double bonus) { this.bonus += bonus; }

    @Override
    public double pay() {
        double payment = super.pay() + bonus;
        bonus = 0;
        return payment;
    }
}
