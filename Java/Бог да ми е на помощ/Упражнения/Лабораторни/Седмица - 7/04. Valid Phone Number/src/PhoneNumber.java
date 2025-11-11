import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PhoneNumber {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\b08\\d{8}\\b");

        System.out.println("Телефонен номер е валиден ако започва с 08 и съдържа общо 10 цифри!");
        System.out.print("Въведете телефонен номер: ");
        String phoneNumber = input.nextLine();

        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.find()) {
            System.out.println("Телефонният номер е валиден!");
        } else {
            System.out.println("Телефонният номер е валиден!");
        }

        input.close();
    }
}
