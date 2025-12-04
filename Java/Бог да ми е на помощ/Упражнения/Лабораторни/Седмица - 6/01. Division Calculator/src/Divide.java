/*Напиши програма „DivisionCalculator“, която:
1. Изисква от потребителя две цели числа – делимо и делител.
2. Изчислява резултата от делението.
3. Ако потребителят въведе невалидно число или се опита да дели на 0, програмата не спира, а показва съобщение за грешка и позволява нов опит.

Изисквания:
Използвай конструкцията try-catch-finally.

Хвани:
-   ­ArithmeticException – при деление на 0
-   ­InputMismatchException – при нечислов вход (ако се използва Scanner)
-   ­В finally блок покажи съобщение „Опитът за изчисление приключи.“
-   ­Програмата да се повтаря, докато потребителят не въведе команда за край (например число -1 като делител).*/

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
                System.out.printf("Възникна неочаквана грешка: %s%n", error.getMessage());
            } finally {
                System.out.println("Опитът за изчисление приключи!\n");
            }
        }

        input.close();
    }
}
