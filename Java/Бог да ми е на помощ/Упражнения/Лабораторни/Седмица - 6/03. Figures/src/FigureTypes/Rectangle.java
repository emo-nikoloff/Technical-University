package FigureTypes;

import Info.Drawable;

public class Rectangle extends Figure implements Drawable {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Страните трябва да са положителни!");
        }
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * height + 2 * width;
    }

    @Override
    public void draw() {
        System.out.printf("Правоъгълник с височина: %.2f и широчина: %.2f%n", height, width);
        System.out.printf("Лице: %.2f%n", calculateArea());
        System.out.printf("Периметър: %.2f%n%n", calculatePerimeter());
    }
}
