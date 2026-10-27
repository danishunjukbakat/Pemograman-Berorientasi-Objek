import java.util.Scanner;

public class ParseInts {
    public static void main(String[] args) {
        int sum = 0;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter a line of text");
            try (Scanner scanLine = new Scanner(scan.nextLine())) {
                while (scanLine.hasNext()) {
                    try {
                        int val = Integer.parseInt(scanLine.next());
                        sum += val;
                    } catch (NumberFormatException e) {
                        // Token sudah dikonsumsi; lanjutkan ke token berikutnya.
                    }
                }
            }
        }
        System.out.println("The sum of the integers on this line is " + sum);
    }
}
