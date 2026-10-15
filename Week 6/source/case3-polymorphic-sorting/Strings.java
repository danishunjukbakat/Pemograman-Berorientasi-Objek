import java.util.Arrays;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan jumlah kata lalu seluruh katanya:");
        int size = scan.nextInt();
        String[] stringList = new String[size];
        for (int i = 0; i < size; i++) { stringList[i] = scan.next(); }
        System.out.println("Before: " + Arrays.toString(stringList));
        if (args.length > 0 && args[0].equals("selection")) {
            Sorting.selectionSort(stringList);
            System.out.println("Selection ascending: " + Arrays.toString(stringList));
        } else {
            Sorting.insertionSort(stringList);
            System.out.println("Insertion descending: " + Arrays.toString(stringList));
        }
    }
}
