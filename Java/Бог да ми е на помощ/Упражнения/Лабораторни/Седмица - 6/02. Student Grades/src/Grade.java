import java.util.Scanner;

public class Grade {
    public static void main(String[] args) throws InvalidGradeException {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Въведи оценка: ");
            int grade = Integer.parseInt(input.nextLine());

            if (grade < 2 || grade > 6) {
                throw new InvalidGradeException();
            }

            System.out.printf("Валидна оценка: %d%n", grade);
        } catch (InvalidGradeException error) {
            System.out.println(error.getMessage());
        } catch (NumberFormatException error) {
            System.out.println("Грешка: Въведени грешни данни!");
        } finally {
            input.close();
        }
    }
}
