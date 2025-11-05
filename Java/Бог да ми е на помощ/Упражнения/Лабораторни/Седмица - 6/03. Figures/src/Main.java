import Sculpt.Circle;
import Sculpt.Drawable;
import Sculpt.Figure;
import Sculpt.Rectangle;
import Sculpt.ShapeDrawer;
import Sculpt.Square;

public class Main {
    public static void main(String[] args) throws Exception {
        ShapeDrawer drawer = new ShapeDrawer();

        System.out.println("--- Коректни обекти ---");

        Figure mySquare = new Square(5.0);
        Figure myCircle = new Circle(3.5);

        drawer.drawShape((Drawable) mySquare);
        drawer.drawShape((Drawable) myCircle);

        System.out.printf("Площ на квадрата: %.2f%n", mySquare.calculateArea());
        System.out.printf("Периметър на кръга: %.2f%n", myCircle.calculatePerimeter());

        System.out.println("\n--- Обработка на изключения (Некоректни размери) ---");

        try {
            Figure invalidCircle = new Circle(0);
            drawer.drawShape((Drawable) invalidCircle);

        } catch (IllegalArgumentException msg) {
            System.err.println("Грешка при създаване на кръг: " + msg.getMessage());
        }

        try {
            Figure invalidRectangle = new Rectangle(-10.0, 5.0);
            drawer.drawShape((Drawable) invalidRectangle);

        } catch (IllegalArgumentException msg) {
            System.err.println("Грешка при създаване на правоъгълник: " + msg.getMessage());
        }
    }
}
