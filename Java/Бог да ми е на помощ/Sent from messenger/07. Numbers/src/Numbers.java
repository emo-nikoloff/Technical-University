/* 1. Напишете програма, която отпечатва на конзолата числата от 1 до N. Числото N се чете от стандартния вход.
2. Напишете програма, която отпечатва на конзолата числата от N до 1. Числото N се чете от стандартния вход.
3. Напишете програма, която отпечатва на конзолата числата от 1 до N, които не се делят на 3 и 7. Числото N се чете от стандартния вход.
4. Напишете програма, която отпечатва на конзолата числата от 1 до N, които се делят на 5 и 7 едновременно. Числото N се чете от стандартния вход.
5. Напишете програма, която чете от конзолата N цели числа и отпечатва най-малкото и най-голямото от тях.
6. Да се напише програма, която чете n на брой цели числа, въведени от потребителя, и ги сумира.*/

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(input.nextLine());

        System.out.printf("The numbers from 1 to %d:%n", number);
        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }

        System.out.println();

        System.out.printf("The numbers from %d to 1:%n", number);
        for (int i = number; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.printf("The numbers from 1 to %d that are not divisible to 3 and 7:%n", number);
        for (int i = 1; i <= number; i++) {
            if (i % 3 != 0 && i % 7 != 0)
                System.out.println(i);
        }

        System.out.println();

        System.out.printf("The numbers from 1 to %d that are divisible to 5 and 7:%n", number);
        for (int i = 1; i <= number; i++) {
            if (i % 5 == 0 && i % 7 == 0)
                System.out.println(i);
        }

        System.out.println();

        System.out.printf("Enter a new range: ");
        int range = Integer.parseInt(input.nextLine());

        System.out.printf("Random numbers from 1 to %d:%n", range);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i <= range; i++) {
            System.out.print("Enter a number: ");
            int digit = Integer.parseInt(input.nextLine());

            if (digit < min) {
                min = digit;
            } else if (digit > max) {
                max = digit;
            }

            sum += digit;
        }
        System.out.println();
        System.out.printf("Biggest number: %d%n", max);
        System.out.printf("Smallest number: %d%n", min);
        System.out.printf("The sum of these numbers is: %d%n", sum);

        input.close();
    }
}
