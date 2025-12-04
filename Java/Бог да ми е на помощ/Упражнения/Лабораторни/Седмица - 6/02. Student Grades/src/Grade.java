/*Напиши програма „StudentGrades“, която:
1. Изисква от потребителя да въведе оценка (цяло число от 2 до 6).
2. Ако въведената оценка е извън обхвата 2–6, да се хвърли собствено изключение InvalidGradeException.
3. Изключението да се улови и да се покаже съобщение с причината за грешката.
4. Програмата да продължава да работи, докато не се въведе 0 (за край).
Изисквания:
Създай клас InvalidGradeException, който:
-   ­наследява Exception (Checked Exception);
-   ­има конструктор, който приема съобщение (super(message)).

В метода, който проверява оценката, хвърли:
-   ­throw new InvalidGradeException("Оценката трябва да е между 2 и 6!");
-   ­Хвани изключението в main с try-catch.*/

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
