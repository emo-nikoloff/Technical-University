package Sculpt;

public class Square extends Figure implements Drawable {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Размерът на страната трябва да е положително число.");
        }
        this.side = side;
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
        System.out.printf("Чертая Квадрат със страна %.2f. Площ: %.2f, Периметър: %.2f%n",
                side, calculateArea(), calculatePerimeter());
    }
}
