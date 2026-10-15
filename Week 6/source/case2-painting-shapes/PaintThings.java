import java.util.Locale;

public class PaintThings {
    public static void main(String[] args) {
        final double COVERAGE = 350;
        Paint paint = new Paint(COVERAGE);
        Rectangle deck = new Rectangle(20, 35);
        Sphere bigBall = new Sphere(15);
        Cylinder tank = new Cylinder(10, 30);

        double deckAmt = paint.amount(deck);
        double ballAmt = paint.amount(bigBall);
        double tankAmt = paint.amount(tank);
        System.out.printf(Locale.US, "deck = %.6f%n", deckAmt);
        System.out.printf(Locale.US, "bigBall = %.6f%n", ballAmt);
        System.out.printf(Locale.US, "tank = %.6f%n", tankAmt);

        Shape s;
        s = deck;
        System.out.println(s + " area=" + s.area());
        s = bigBall;
        System.out.println(s + " area=" + s.area());
        s = tank;
        System.out.println(s + " area=" + s.area());
    }
}
