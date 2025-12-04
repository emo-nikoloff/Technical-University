/*Напишете програма, която чете низ и брои колко гласни букви има в него.*/

import java.util.Scanner;

public class Checker {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Въведете низ: ");
        String text = input.nextLine();

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char letter = Character.toLowerCase(text.charAt(i));

            switch (letter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }

        System.out.printf("Брой гласни: %d%n", count);

        input.close();
    }
}
