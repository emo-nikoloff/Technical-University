/*Да се напише клас фирма (Company), който има следните член променливи:
•    Име на фирмата – тип string;
•    Дата на създаване на фирмата – тип string;
•    Булстат – уникален 10 знаков код включващ букви и цифри – тип string.
За всички член променливи напишете get и set методи, като за последния направете проверка за дължина на string-а в set-метода му(length = 10).

Да се напише клас Фирма-ЕТ, който да наследява класа Фирма и да има следните член променливи:
•    Име на собственика, учредил фирмата- тип string;
•    Първоначален капитал – тип double;
•    Актуален капитал – тип double;
За всички член променливи напишете get и set методи.

Класът Фирма-ЕТ трябва да има метод, който изчислява печалбата към днешна дата на фирмата. Той трябва да бъде нестатичен, да не приема параметри, и трябва да връща като резултат число double,
което да бъде разликата межу актуалния и първоначалния капитал на съответната фирма.*/

import java.util.Scanner;

public class Business {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        CompanyET company = new CompanyET();

        System.out.print("Enter the company's name: ");
        company.setName(input.nextLine());

        System.out.print("Enter the company's founding date: ");
        company.setDate(input.nextLine());

        System.out.print("Enter the company's Bulstat: ");
        company.setBulstat(input.nextLine());

        System.out.print("Enter the founder's name: ");
        company.setFounderName(input.nextLine());

        System.out.print("Enter the starting fund: ");
        company.setStartingFund(Double.parseDouble(input.nextLine()));

        System.out.print("Enter the current fund: ");
        company.setRealFund(Double.parseDouble(input.nextLine()));

        double todayFund = company.todayFund();

        System.out.println("\n--- Company Information ---");
        System.out.println("Company's name: " + company.getName());
        System.out.println("Company's founding date: " + company.getDate());
        System.out.println("Company's bulstat: " + company.getBulstat());
        System.out.println("Company's founder: " + company.getFounderName());
        System.out.println("Company's starting fund: " + company.getStartingFund());
        System.out.println("Company's current fund: " + company.getRealFund());
        System.out.println("The difference from the start till now: " + todayFund);

        input.close();
    }
}
