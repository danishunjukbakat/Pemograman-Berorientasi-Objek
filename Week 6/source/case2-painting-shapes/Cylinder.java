public class Cylinder extends Shape {
    private double radius, height;
    public Cylinder(double radius, double height) {
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double area() {
        // Asumsi: luas permukaan tabung tertutup; starter tidak disertakan.
        return 2 * Math.PI * radius * (radius + height);
    }
    @Override
    public String toString() {
        return super.toString() + " radius " + radius + " height " + height;
    }
}
