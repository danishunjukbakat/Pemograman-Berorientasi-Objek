public class WeeklySales {
    public static void main(String[] args) {
        // Data demonstrasi, bukan klaim salinan starter yang tidak dilampirkan.
        Salesperson[] salesStaff = {
            new Salesperson("Jane", "Jones", 3000),
            new Salesperson("Pat", "Jones", 4000),
            new Salesperson("Bob", "Meeker", 4000),
            new Salesperson("Dan", "Smith", 5000),
            new Salesperson("Frank", "Black", 3000),
            new Salesperson("John", "Smith", 7000),
            new Salesperson("Al", "Graney", 8000),
            new Salesperson("Hugh", "Albright", 2000),
            new Salesperson("Alan", "Meeker", 6000),
            new Salesperson("Josh", "Bush", 1000)
        };
        Sorting.insertionSort(salesStaff);
        System.out.println("Weekly sales descending:");
        for (Salesperson person : salesStaff) { System.out.println(person); }
    }
}
