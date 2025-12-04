/*Напишете програма, която чете потребителски имена от един ред (свързани с ", ") и отпечатва всички валидни потребителски имена. Валидното потребителско име е:
• Дължината му е между 3 и 16 знака.
• Съдържа само букви, цифри, тирета и подчертавки.*/

import java.util.Scanner;

public class ValidUser {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Въведете потребителски имена: ");
        String usernames = input.nextLine();

        String[] users = usernames.split(", ");

        System.out.println("Валидни потребителски имена:");
        for (String user : users) {
            if (user.matches("[a-zA-Z0-9_-]{3,16}")) {
                System.out.println(user);
            }
        }

        input.close();
    }
}
