/* Напишете програма, която намира сбора на две числа въведени от потребителя.*/

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double firstNumber = Double.parseDouble(input.nextLine());
        System.out.print("Enter second number: ");
        double secondNumber = Double.parseDouble(input.nextLine());

        System.out.printf("%.2f + %.2f = %.2f", firstNumber, secondNumber, firstNumber + secondNumber);

        input.close();
    }
}
