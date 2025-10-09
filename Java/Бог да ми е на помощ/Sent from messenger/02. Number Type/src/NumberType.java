// Да се напише програма, която чете цяло число, въведено от потребителя, и отпечатва на конзолата дали е четно или нечетно. 

import java.util.Scanner;

public class NumberType {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(input.nextLine());

        if (number % 2 == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }

        input.close();
    }
}
