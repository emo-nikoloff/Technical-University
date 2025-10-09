// Напишете програма, която чете цяло число n, въведено от потребителя. Ако числото не се дели на 10 без остатък, отпечатайте съобщение за грешка. Подканете потребителя да въведе ново число, докато не
// въведе стойност, която се дели на 10 без остатък.

import java.util.Scanner;

public class DividingRemainder {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(input.nextLine());

        while (number % 10 != 0) {
            System.out.println("The number can't be divided by 10 without a remainder");
            System.out.printf("Enter a new number: ");
            number = Integer.parseInt(input.nextLine());
        }

        System.out.println("You made it!!!");
        System.out.printf("%d can be divided by 10 without a remainder", number);

        input.close();
    }
}
