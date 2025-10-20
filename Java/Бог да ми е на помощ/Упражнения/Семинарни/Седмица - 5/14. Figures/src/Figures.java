/* Да се напише програма, в която потребителят въвежда вида и размерите на геометрична фигура и пресмята лицето ѝ. Фигурите са четири вида: квадрат (square), правоъгълник (rectangle), кръг (circle) и
триъгълник (triangle). На първия ред на входа се чете вида на фигурата (square, rectangle, circle или triangle).
    •	Ако фигурата е квадрат, на следващия ред се чете едно число - дължина на страната му
    •	Ако фигурата е правоъгълник, на следващите два реда четат две числа - дължините на страните му
    •	Ако фигурата е кръг, на следващия ред се чете едно число - радиусът на кръга
    •	Ако фигурата е триъгълник, на следващите два реда четат две числа - дължината на страната му и дължината на височината към нея
Резултатът да се закръгли до 3 цифри след десетичната точка.*/

import java.util.Scanner;

public class Figures {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a figure's type (square, rectangle, circle or triangle):");
        String figureType = input.nextLine();

        switch (figureType) {
            case "square":
                System.out.print("Enter a side: ");
                double border = Double.parseDouble(input.nextLine());

                double sqareFace = border * border;
                System.out.printf("Sqare's face: %.3f", sqareFace);
                break;
            case "rectangle":
                System.out.print("Enter a width: ");
                double width = Double.parseDouble(input.nextLine());
                System.out.print("Enter a height: ");
                double height = Double.parseDouble(input.nextLine());

                double rectangleFace = width * height;
                System.out.printf("Rectangle's face: %.3f", rectangleFace);
                break;
            case "circle":
                System.out.print("Enter a radius: ");
                double radius = Double.parseDouble(input.nextLine());

                double circleFace = Math.PI * radius * radius;
                System.out.printf("Circle's face: %.3f", circleFace);
                break;
            case "triangle":
                System.out.print("Enter a side: ");
                double side = Double.parseDouble(input.nextLine());
                System.out.print("Enter side's height: ");
                double sideHeight = Double.parseDouble(input.nextLine());

                double triangleFace = (side * sideHeight) / 2;
                System.out.printf("Triangle's face: %.3f", triangleFace);
                break;
            default:
                System.out.println("Invalid figure type!");
                break;
        }

        input.close();
    }
}
