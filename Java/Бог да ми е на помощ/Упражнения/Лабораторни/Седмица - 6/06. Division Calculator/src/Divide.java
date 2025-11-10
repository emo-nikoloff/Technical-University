import java.util.Scanner;

public class Divide {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Въведи цяло число делимо: ");
                int dividend = Integer.parseInt(input.nextLine());

                System.out.print("Въведи цяло число делител (-1 за край): ");
                int divisor = Integer.parseInt(input.nextLine());

                if (divisor == -1) {
                    System.out.println("Програмата приключва по команда.");
                    break;
                }

                double result = (double) dividend / divisor;
                System.out.printf("Резултат: %.2f%n", result);
            } catch (ArithmeticException error) {
                System.out.println("Грешка: Не може да се дели на нула!");
            } catch (NumberFormatException error) {
                System.out.println("Грешка: Невалидни входни данни!");
            } catch (Exception error) {
                System.out.printf("Възникна неочаквана грешка: %s%n!", error.getMessage());
            } finally {
                System.out.println("Опитът за изчисление приключи!\n");
            }
        }

        input.close();
    }
}
