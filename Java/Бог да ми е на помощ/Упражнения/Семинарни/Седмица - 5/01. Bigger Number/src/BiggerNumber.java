/* Да се напише програма, която чете две цели числа въведени от потребителя и отпечатва по-голямото от двете.*/

import java.util.Scanner;

public class BiggerNumber {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int firstNumber = Integer.parseInt(input.nextLine());
        System.out.print("Enter second number: ");
        int secondNumber = Integer.parseInt(input.nextLine());

        System.out.printf("The bigger number is: %d", Math.max(firstNumber, secondNumber));

        input.close();
    }
}
