// Raw Comparable mengikuti batas praktikum; generics bukan target modul.
@SuppressWarnings({"rawtypes", "unchecked"})
public class Sorting {
    public static void selectionSort(Comparable[] list) {
        for (int index = 0; index < list.length - 1; index++) {
            int min = index;
            for (int scan = index + 1; scan < list.length; scan++) {
                if (list[scan].compareTo(list[min]) < 0) { min = scan; }
            }
            Comparable temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }

    public static void insertionSort(Comparable[] list) {
        for (int index = 1; index < list.length; index++) {
            Comparable key = list[index];
            int position = index;
            // > 0 menggeser elemen lebih kecil agar urutan descending.
            while (position > 0 && key.compareTo(list[position - 1]) > 0) {
                list[position] = list[position - 1];
                position--;
            }
            list[position] = key;
        }
    }
}
