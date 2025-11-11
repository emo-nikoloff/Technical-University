import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Въведете дума: ");
        String string = input.nextLine();

        boolean isPalindrome = true;

        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if (string.toLowerCase().charAt(i) != string.toLowerCase().charAt(j)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.printf("Думата: %s%n", string);
        System.out.printf("Палиндром ли е?: %b%n", isPalindrome);

        input.close();
    }
}
