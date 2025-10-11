/* Напишете програма, която проверява дали въведено от потребителя число е валидно. За да е валидно числото, то трябва да е по-голямо или равно на 1 и в същото време да се дели на 5 без остатък.
Ако числото е валидно, отпечатайте "Valid!". В противен случай, отпечатайте "Invalid!".*/

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(input.nextLine());

        if (number >= 1 && number % 5 == 0) {
            System.out.println("Valid!");
        } else {
            System.out.println("Invalid!");
        }

        input.close();
    }
}
