/* 1. Напишете програма, която пресмята N!/K! за дадени N и K (1<K<N).
2. Напишете програма, която пресмята N!*K!/(N-K)! за дадени N и K.*/

import java.util.Scanner;

public class ValidResult {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int firstNumber = Integer.parseInt(input.nextLine());
        System.out.print("Enter second number: ");
        int secondNumber = Integer.parseInt(input.nextLine());

        while (secondNumber <= 1 || firstNumber <= secondNumber) {
            System.out.println("The numbers should be (1 < second number < first number)! Enter new numbers:");
            System.out.print("Enter first number: ");
            firstNumber = Integer.parseInt(input.nextLine());
            System.out.print("Enter second number: ");
            secondNumber = Integer.parseInt(input.nextLine());
        }

        int tempFirstNumber = firstNumber;
        int tempSecondNumber = secondNumber;

        for (int i = firstNumber - 1; i > 0; i--) {
            firstNumber *= i;
        }

        for (int i = secondNumber - 1; i > 0; i--) {
            secondNumber *= i;
        }

        System.out.printf("%d! / %d! = %d%n", tempFirstNumber, tempSecondNumber, firstNumber / secondNumber);

        int thirdNumber = tempFirstNumber - tempSecondNumber;

        for (int i = thirdNumber - 1; i > 0; i--) {
            thirdNumber *= i;
        }

        System.out.printf("(%d! * %d!) / (%d - %d)! = %d", tempFirstNumber, tempSecondNumber,
                tempFirstNumber, tempSecondNumber,
                firstNumber * secondNumber / thirdNumber);

        input.close();
    }
}
