/* 1. Да се напише програма, която чете цяло число и проверява дали е в интервала [-100, 100] и е различно от 0. Програмата трябва да извежда "Yes", ако числото отговаря на условията, и "No" в случай че
не е валидно.

2. Дадено число е валидно, ако е в диапазона [100…200]. Да се напише програма, която чете цяло число, въведено от потребителя, и печата "invalid" ако въведеното число не е валидно.*/

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter task number (1 or 2): ");
        int task = Integer.parseInt(input.nextLine());

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(input.nextLine());

        switch (task) {
            case 1:
                if (number >= -100 && number <= 100 && number != 0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
                break;
            case 2:
                if (number >= 100 && number <= 200) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }
            default:
                break;
        }

        input.close();
    }
}
