/*Напишете програма, която заменя всички цифри със символ * в изречение.*/

import java.util.Scanner;

public class DigitsReplacing {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Въведи изречение: ");
        String sentence = input.nextLine();

        sentence = sentence.replaceAll("\\d", "*");

        System.out.printf("Изречението със заменени числа (ако има такива): %s%n", sentence);

        input.close();
    }
}
