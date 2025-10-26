import Sculpt.Shape;
import Sculpt.Circle;
import Sculpt.Rectangle;

public class Main {
    public static void main(String[] args) throws Exception {
        Shape circle = new Circle("blue", 8);
        Shape rectangle = new Rectangle("red", 10, 5);

        Shape[] shapes = { circle, rectangle };

        for (Shape shape : shapes) {
            System.out.print("Фигурата е ");
            if (shape instanceof Circle) {
                System.out.println("кръг");
            } else {
                System.out.println("правоъгълник");
            }
            shape.displayColor();
            System.out.printf("Лице: %.2f%n", shape.area());
            System.out.printf("Периметър: %.2f%n%n", shape.perimeter());
        }
    }
}
