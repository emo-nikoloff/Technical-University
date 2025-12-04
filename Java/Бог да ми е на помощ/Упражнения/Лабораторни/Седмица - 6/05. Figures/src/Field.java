/*Създайте абстрактен клас Figure, който да съдържа следните методи: calculateArea(), който трябва да връща лицето на фигурата (double), и calculatePerimeter(), който трябва да връща периметъра
на фигурата (double). За всеки клас, който представлява конкретна фигура (Square, Rectangle и Circle), да се реализират съответните методи за пресмятане на лицето и периметъра. Да се създаде
интерфейс Drawable, който да има метод draw(), който не връща нищо и просто извежда информация за фигурата. Да се създаде клас ShapeDrawer, който да има метод drawShape(Drawable shape), който
приема обект, реализиращ интерфейса Drawable, и извиква метода draw() на подадената фигура. Да се обработят възможни изключения при некоректни данни, например ако се опитаме да създадем фигура с
отрицателни размери (при триъгълник) или ако размерите на фигурите са отрицателни.*/

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
