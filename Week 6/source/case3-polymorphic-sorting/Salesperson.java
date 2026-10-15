@SuppressWarnings("rawtypes")
public class Salesperson implements Comparable {
    private String firstName, lastName;
    private int totalSales;
    public Salesperson(String firstName, String lastName, int totalSales) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSales = totalSales;
    }
    @Override
    public int compareTo(Object other) {
        Salesperson otherSales = (Salesperson) other;
        int bySales = Integer.compare(totalSales, otherSales.totalSales);
        if (bySales != 0) { return bySales; }
        int byLastName = lastName.compareTo(otherSales.lastName);
        if (byLastName != 0) { return byLastName; }
        return firstName.compareTo(otherSales.firstName);
    }
    @Override
    public String toString() {
        return lastName + ", " + firstName + " : " + totalSales;
    }
}
