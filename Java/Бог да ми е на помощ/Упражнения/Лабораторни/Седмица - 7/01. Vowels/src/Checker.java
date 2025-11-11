import java.util.Scanner;

public class Checker {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Въведете низ: ");
        String string = input.nextLine();

        int vowelCount = 0;
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.toLowerCase().charAt(i);
            if (currentChar == 'a' ||
                    currentChar == 'e' ||
                    currentChar == 'i' ||
                    currentChar == 'o' ||
                    currentChar == 'u') {
                vowelCount++;
            }
        }

        System.out.printf("Въведеният низ: %s%n", string);
        System.out.printf("Брой гласни: %d%n", vowelCount);

        input.close();
    }
}
