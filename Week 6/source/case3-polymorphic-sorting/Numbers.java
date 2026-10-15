import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan jumlah angka lalu seluruh angkanya:");
        int size = scan.nextInt();
        Integer[] intList = new Integer[size];
        for (int i = 0; i < size; i++) { intList[i] = scan.nextInt(); }
        System.out.println("Before: " + Arrays.toString(intList));
        if (args.length > 0 && args[0].equals("selection")) {
            Sorting.selectionSort(intList);
            System.out.println("Selection ascending: " + Arrays.toString(intList));
        } else {
            Sorting.insertionSort(intList);
            System.out.println("Insertion descending: " + Arrays.toString(intList));
        }
    }
}
