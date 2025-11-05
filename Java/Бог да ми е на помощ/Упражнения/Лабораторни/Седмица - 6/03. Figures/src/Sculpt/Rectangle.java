package Sculpt;

public class Rectangle extends Figure implements Drawable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Размерите на правоъгълника трябва да са положителни числа.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * length + 2 * width;
    }

    @Override
    public void draw() {
        System.out.printf("Чертая Правоъгълник с дължина %.2f и ширина %.2f. Площ: %.2f, Периметър: %.2f%n",
                length, width, calculateArea(), calculatePerimeter());
    }
}
