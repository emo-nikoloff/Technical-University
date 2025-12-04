/*1. Да се създаде абстрактен клас Shape, който съдържа:
•   поле color от тип String,
•   конструктор, който инициализира цвета,
•   абстрактен метод double area() – изчислява лицето на фигурата,
•   абстрактен метод double perimeter() – изчислява периметъра на фигурата,
•   метод void displayColor() – извежда на екрана цвета на фигурата.
2. Да се създадат два класа, които наследяват Shape:
Circle – описва кръг
•   поле radius
•   имплементира методите area() и perimeter()
Rectangle – описва правоъгълник
•   полета width и height
•   имплементира методите area() и perimeter()
3. Да се създаде главен клас Main, в който:
•   се създават обекти от тип Shape, но с конкретни реализации Circle и Rectangle;
•   всички фигури се съхраняват в масив (или списък) Shape[] shapes;
•   чрез полиморфизъм за всяка фигура се извеждат:
    o   видът на фигурата,
    o   нейният цвят,
    o   лицето ѝ и периметърът ѝ.*/

import Sculpt.Shape;
import Sculpt.Circle;
import Sculpt.Rectangle;

public class SculptField {
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
