package FigureTypes;

import Info.Drawable;

public class Circle extends Figure implements Drawable {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиусът трябва да е положителен!");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
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
        System.out.printf("Кръг с радиус: %.2f%n", radius);
        System.out.printf("Лице: %.2f%n", calculateArea());
        System.out.printf("Периметър: %.2f%n%n", calculatePerimeter());
    }
}
