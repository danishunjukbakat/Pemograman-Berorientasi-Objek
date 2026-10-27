public class MathUtils {
    public static long factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("nilai tidak boleh negatif: " + n);
        }
        if (n > 16) {
            throw new IllegalArgumentException(
                    "nilai terlalu besar; batas latihan factorial adalah 16: " + n);
        }

        // int hanya akurat hingga 12!; long menjaga hasil 13!..16! tetap benar.
        long fac = 1L;
        for (int i = n; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }
}
