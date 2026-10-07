import java.util.Calendar;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("Tahun pengujian: "
                + Calendar.getInstance().get(Calendar.YEAR));
        Employee[] ordinary = {
            new Employee("Antonio Rossi", 2000000, 1, 10, 1989),
            new Employee("Maria Bianchi", 2500000, 1, 12, 1991),
            new Employee("Isabel Vidal", 3000000, 1, 11, 1993)
        };
        System.out.println("Employee sebelum kenaikan:");
        for (Employee e : ordinary) e.print();
        for (Employee e : ordinary) e.raiseSalary(5);
        System.out.println("Employee sesudah kenaikan 5%:");
        for (Employee e : ordinary) e.print();

        Employee[] staff = {
            new Employee("Antonio Rossi", 2000000, 1, 10, 1989),
            new Manager("Maria Bianchi", 2500000, 1, 12, 1991),
            new Employee("Isabel Vidal", 3000000, 1, 11, 1993)
        };
        System.out.println("Staff sebelum kenaikan:");
        for (Employee e : staff) e.print();
        for (Employee e : staff) e.raiseSalary(5);
        System.out.println("Staff sesudah kenaikan:");
        for (Employee e : staff) e.print();
        System.out.println("compare staff[0], staff[1]: "
                + staff[0].compare(staff[1]));
        System.out.println("compare staff[1], staff[2]: "
                + staff[1].compare(staff[2]));
        System.out.println("compare staff[2], staff[0]: "
                + staff[2].compare(staff[0]));
        System.out.println("compare salary sama: "
                + staff[0].compare(new Employee("Equal", 2100000,
                                                1, 1, 2020)));
        Manager m = new Manager("Maria Bianchi", 2500000, 1, 12, 1991);
        Employee e = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);
        System.out.println("Manager.compare sebelum kenaikan: "
                + m.compare(e));
        Sortable sortableManager = m;
        System.out.println("Manager melalui Sortable: "
                + sortableManager.compare(e));
    }
}
