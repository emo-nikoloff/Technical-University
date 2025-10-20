/* Напишете програма, която чете текст от конзолата и го принтира, докато не получи командата "Stop".*/

import java.util.Scanner;

public class Strings {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter text: ");
            String text = input.nextLine();

            if (text.equals("Stop")) {
                break;
            }
        }

        input.close();
    }
}
