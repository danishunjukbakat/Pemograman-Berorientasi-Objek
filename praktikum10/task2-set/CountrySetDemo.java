import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CountrySetDemo {
    public static void main(String[] args) {
        HashSet<String> countries = new HashSet<>();
        countries.add("Indonesia");
        countries.add("Japan");
        countries.add("Malaysia");
        countries.add("Singapore");
        countries.add("Thailand");
        countries.add("Indonesia");

        System.out.println("=== HashSet<String> ===");
        System.out.println(countries);
        System.out.println("Jumlah elemen = " + countries.size());
        System.out.println("contains Indonesia = " + countries.contains("Indonesia"));

        countries.remove("Japan");
        System.out.println("Setelah remove Japan = " + countries);
        System.out.println("Jumlah setelah remove = " + countries.size());

        // Collections.sort(countries); // Tidak valid: sort membutuhkan List.
        ArrayList<String> sortedCountries = new ArrayList<>(countries);
        Collections.sort(sortedCountries);
        System.out.println("Set dari ArrayList setelah sort = " + sortedCountries);
    }
}
