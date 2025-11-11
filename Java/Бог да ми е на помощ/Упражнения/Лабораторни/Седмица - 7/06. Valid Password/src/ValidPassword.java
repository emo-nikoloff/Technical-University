import java.util.Scanner;

public class ValidPassword {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Въведете парола: ");
        String password = input.nextLine();

        if (password.matches("^(?=.*[a-zA-Z])(?=.*\\d).{8,}$")) {
            System.out.println("Паролата е валидна");
        } else {
            System.out.println("Паролата е невалидна");
        }

        input.close();
    }
}
