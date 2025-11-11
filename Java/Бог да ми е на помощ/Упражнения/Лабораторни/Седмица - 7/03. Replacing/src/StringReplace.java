import java.util.Scanner;

public class StringReplace {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Въведете дума: ");
        String string = input.nextLine();

        string = string.toLowerCase().replaceAll(" ", "_");

        System.out.printf("Думата: %s%n", string);

        input.close();
    }
}
