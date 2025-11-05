import java.util.Scanner;

import Operations.Operation;
import Operations.Calculator;
import Operations.Addition;
import Operations.Division;
import Operations.Multiplication;
import Operations.Subtraction;

public class Calculate {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Calculator calculator = new Calculator();
        Operation operation = null;

        double firstNumber = Double.parseDouble(input.nextLine());
        double secondNumber = Double.parseDouble(input.nextLine());
        String operationChoice = input.nextLine();

        switch (operationChoice) {
            case "+":
                operation = new Addition();
                break;
            case "-":
                operation = new Subtraction();
                break;

            case "*":
                operation = new Multiplication();
                break;

            case "/":
                operation = new Division();
                break;
            default:
                System.out.println("Няма такава операция!");
                input.close();
                return;
        }

        System.out.printf("Резултатът е: %.2f", calculator.performAction(operation, firstNumber, secondNumber));

        input.close();
    }
}
