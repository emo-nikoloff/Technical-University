/* Снимките за дългоочаквания филм "Годзила срещу Конг" започват. Сценаристът Адам Уингард ви моли да напишете програма, която да изчисли дали предвидените средства са достатъчни за снимането на филма.
За снимките ще бъдат нужни определен брой статисти, облекло за всеки статист и декор.
Известно е, че:
    •	Декорът за филма е на стойност 10% от бюджета. 
    •	При повече от 150 статисти,  има отстъпка за облеклото на стойност 10%.
Вход
От конзолата се четат 3 реда:
- Бюджет за филма – реално число в интервала 1.00-1000000.00
- Брой на статистите – цяло число в интервала 1-500
- Цена за облекло на един статист – реално число в интервала 1.00-1000.00
Изход
На конзолата трябва да се отпечатат два реда:
    •	Ако парите за декора и дрехите са повече от бюджета:
        o	"Not enough money!"
        o	"Wingard needs {парите недостигащи за филма} leva more."
    •	Ако парите за декора и дрехите са по малко или равни на бюджета:
        o	"Action!" 
        o	"Wingard starts filming with {останалите пари} leva left."
Резултатът трябва да е форматиран до втория знак след десетичната запетая.*/

import java.util.Scanner;

public class Movie {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        double budget = Double.parseDouble(input.nextLine());
        int extras = Integer.parseInt(input.nextLine());
        double clothingPrice = Double.parseDouble(input.nextLine());

        double decor = budget * 0.1;
        double clothingCost = extras * clothingPrice;

        if (extras > 150) {
            clothingCost = clothingCost - clothingCost * 0.10;
        }

        double totalCost = decor + clothingCost;
        double difference = Math.abs(budget - totalCost);

        if (totalCost > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", difference);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", difference);
        }

        input.close();
    }
}
