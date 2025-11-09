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
