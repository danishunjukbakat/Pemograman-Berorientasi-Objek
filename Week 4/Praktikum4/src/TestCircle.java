public class TestCircle {
    public static void main(String[] args) {

        Circle c1 = new Circle(3.0, "blue");

        System.out.println("Sebelum diubah:");
        System.out.println(c1);

        // Mengubah radius dan color melalui setter
        c1.setRadius(5.0);
        c1.setColor("green");

        System.out.println();
        System.out.println("Setelah diubah:");
        System.out.println(c1);

        System.out.println();
        System.out.println("Radius = " + c1.getRadius());
        System.out.println("Color = " + c1.getColor());
        System.out.println("Area = " + c1.getArea());
    }
}