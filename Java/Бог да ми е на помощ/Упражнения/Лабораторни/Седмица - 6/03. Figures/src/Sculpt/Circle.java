package Sculpt;

public class Circle extends Figure implements Drawable {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиусът трябва да е положително число.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.printf("Чертая Кръг с радиус %.2f. Площ: %.2f, Периметър: %.2f%n",
                radius, calculateArea(), calculatePerimeter());
    }
}
