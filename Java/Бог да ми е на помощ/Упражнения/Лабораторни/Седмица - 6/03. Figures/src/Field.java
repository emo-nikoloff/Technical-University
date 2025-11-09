import Info.Drawable;
import Info.ShapeDrawer;
import FigureTypes.Circle;
import FigureTypes.Rectangle;
import FigureTypes.Square;

public class Field {
    public static void main(String[] args) throws Exception {
        ShapeDrawer drawer = new ShapeDrawer();

        try {
            Drawable square = new Square(5);
            Drawable rectangle = new Rectangle(5, 6);
            Drawable circle = new Circle(5);

            drawer.drawShape(square);
            drawer.drawShape(rectangle);
            drawer.drawShape(circle);

            Drawable invalid = new Square(-2);
            drawer.drawShape(invalid);
        } catch (IllegalArgumentException error) {
            System.out.printf("Грешка: %s%n", error.getMessage());
        } catch (Exception error) {
            System.out.printf("Неочаквана грешка: %s%n", error.getMessage());
        }
    }
}
