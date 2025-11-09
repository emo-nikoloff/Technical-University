package FigureTypes;

import Info.Drawable;

public class Square extends Figure implements Drawable {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Страната трябва да е положителна!");
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    @Override
    public void draw() {
        System.out.printf("Квадрат със страна: %.2f%n", side);
        System.out.printf("Лице: %.2f%n", calculateArea());
        System.out.printf("Периметър: %.2f%n%n", calculatePerimeter());
    }
}
