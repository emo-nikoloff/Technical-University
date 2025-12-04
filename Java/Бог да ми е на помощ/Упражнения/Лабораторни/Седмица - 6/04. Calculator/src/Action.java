/*Да се създаде абстрактен клас Operation, който ще съдържа абстрактен метод calculate(double a, double b). Този метод ще бъде реализиран в конкретни класове за всяка от операциите.
Създайте класове Addition, Subtraction, Multiplication и Division, които наследяват Operation. Във всеки от тези класове да се реализира метода calculate, който да извършва съответната операция.
Създайте клас Calculator, който ще съдържа метод performCalculation(Operation operation, double a, double b). Този метод ще получава обект от тип Operation и две числа a и b. Методът трябва да
върне резултата от изпълнението на операцията върху числата a и b. В main метода на главния клас да се създаде обект от тип Calculator. Потребителят ще въвежда от конзолата каква операция
иска да извърши (събиране, изваждане, умножение или деление) и две числа. След това програмата трябва да използва Calculator за изпълнение на съответната операция и да изведе резултата на
конзолата. Добавете обработка на изключения, където е приложимо, например деление на нула или въвеждане на невалидни данни.*/

import java.util.Scanner;

import Operations.Addition;
import Operations.Division;
import Operations.Multiplication;
import Operations.Operation;
import Operations.Subtraction;

public class Action {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calculator calculator = new Calculator();
        Operation operation = null;

        try {
            System.out.print("Въведете операция за изчисление: ");
            String operationType = input.nextLine();

            System.out.print("Въведете първо число: ");
            int firstNumber = Integer.parseInt(input.nextLine());

            System.out.print("Въведете второ число: ");
            int secondNumber = Integer.parseInt(input.nextLine());

            switch (operationType) {
                case "add":
                    operation = new Addition();
                    break;
                case "subtract":
                    operation = new Subtraction();
                    break;
                case "multiply":
                    operation = new Multiplication();
                    break;
                case "divide":
                    operation = new Division();
                    break;
                default:
                    System.out.println("Невалидна операция!");
                    input.close();
                    return;
            }

            double result = calculator.performCalculation(operation, firstNumber, secondNumber);
            System.out.printf("Резултат: %.2f%n", result);

        } catch (NumberFormatException error) {
            System.out.println("Въведете валидни числа!");
        } catch (ArithmeticException error) {
            System.out.println(error.getMessage());
        } catch (Exception error) {
            System.out.println("Възникна неочаквана грешка.");
        } finally {
            input.close();
        }
    }
}
