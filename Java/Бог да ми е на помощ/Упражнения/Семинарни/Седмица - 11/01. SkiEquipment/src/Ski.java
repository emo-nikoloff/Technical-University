/*Да се реализира информационна система за резервация и наем на ски оборудване в ски център. Системата трябва да позволява регистриране на клиенти, преглед на налично оборудване, резервация,
връщане и проверка на наличности според тип и размер.
Ски центърът разполага с различни видове оборудване:
•   ски
•   сноуборд дъски
•   обувки
•   щеки
•   каски
Всеки артикул има следните характеристики:
•   уникален идентификатор (ID)
•   тип (SKI, SNOWBOARD, BOOTS, POLES, HELMET)
•   размер (примерно:
    o   за ски/сноуборд – дължина в сантиметри;
    o   за обувки – номер;
    o   за каски – S/M/L или обиколка в см)
•   наличност – дали в момента е свободен или вече е резервиран/нает
•   цена на наем за 1 ден
Клиентите на ски центъра могат:
•   да разглеждат наличното оборудване
•   да правят резервации за конкретен период (от дата до дата)
•   да връщат оборудването
•   да преглеждат собствените си активни резервации
Системата трябва да поддържа следните операции (логически):
1. Регистрация/логване на клиент
    •   Клиентът се идентифицира с име (или потребителско име).
    •   След логване всички резервации се свързват с това име.
2. Преглед на налично оборудване
    •   Извежда списък с всички артикули, които са свободни за дадена дата (или период).
    •   Показва: ID, тип, размер, цена на ден.
3. Филтриране по тип и размер
    •   Клиентът може да поиска:
        o   само ски
        o   само сноуборд
        o   само обувки
    •   и/или да зададе диапазон за размер (напр. дължина 150–170 см или номер на обувки 40–42).
4. Резервация на оборудване
    •   Клиентът избира:
        o   ID на артикул
        o   период (начална дата и крайна дата)
    •   Системата проверява:
        o   дали артикулът е свободен за целия период
    •   Ако е свободен → създава се резервация на името на клиента.
    •   Ако не е свободен → връща се подходящо съобщение за грешка.
5. Преглед на моите резервации
    •   Показва всички резервации на текущия клиент:
        o   ID на артикул
        o   тип, размер
        o   начален и краен ден
        o   цена за целия период (брой дни × цена на ден)
6. Отмяна на резервация / връщане
    •   Клиентът може да:
        o   отмени бъдеща резервация (преди началната дата)
        o   върне оборудването (ако срокът е изтекъл или в деня на връщане)
    •   Системата трябва да освободи артикула за съответните дати.
7. Изчисляване на обща цена
    •   При създаване или преглед на резервация системата изчислява общата цена:
        o   цена = брой дни * цена на ден
    •   По избор: отстъпка при резервация за повече дни (например над 5 дни – 10% намаление).*/

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Ski {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        SkiCenter skiCenter = new SkiCenter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Система за резервация на ски оборудване (конзолен вариант) ===");
        System.out.print("Моля, въведете име (login): ");
        String clientName = scanner.nextLine().trim();
        while (clientName.isEmpty()) {
            System.out.print("Името не може да е празно. Въведете име: ");
            clientName = scanner.nextLine().trim();
        }

        System.out.println("Здравей, " + clientName + "!");
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Избор: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    handleListAvailable(skiCenter, scanner);
                    break;
                case "2":
                    handleFilter(skiCenter, scanner);
                    break;
                case "3":
                    handleReserve(skiCenter, scanner, clientName);
                    break;
                case "4":
                    handleMyReservations(skiCenter, clientName);
                    break;
                case "5":
                    handleCancelReservation(skiCenter, scanner, clientName);
                    break;
                case "6":
                    printHelp();
                    break;
                case "7":
                    running = false;
                    System.out.println("Изход. Чао!");
                    break;
                default:
                    System.out.println("Невалиден избор. Опитайте пак.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("========== МЕНЮ ==========");
        System.out.println("1) List available equipment for date");
        System.out.println("2) Filter equipment");
        System.out.println("3) Reserve equipment");
        System.out.println("4) Show my reservations");
        System.out.println("5) Cancel reservation");
        System.out.println("6) Help");
        System.out.println("7) Exit");
        System.out.println("==========================");
    }

    private static void handleListAvailable(SkiCenter skiCenter, Scanner scanner) {
        System.out.print("Въведете дата (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine().trim();
        try {
            LocalDate date = LocalDate.parse(dateStr);
            String result = skiCenter.listAvailableForDateAsText(date);
            System.out.println(result);
        } catch (DateTimeParseException e) {
            System.out.println("Грешен формат на дата.");
        }
    }

    private static void handleFilter(SkiCenter skiCenter, Scanner scanner) {
        System.out.println("Тип оборудване (SKI, SNOWBOARD, BOOTS, POLES, HELMET): ");
        String typeStr = scanner.nextLine().trim().toUpperCase();
        EquipmentType type;
        try {
            type = EquipmentType.valueOf(typeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Невалиден тип.");
            return;
        }

        System.out.print("sizeFrom (може да е празно): ");
        String sizeFrom = scanner.nextLine().trim();
        System.out.print("sizeTo (може да е празно): ");
        String sizeTo = scanner.nextLine().trim();

        String result = skiCenter.filterAsText(type, sizeFrom, sizeTo);
        System.out.println(result);
    }

    private static void handleReserve(SkiCenter skiCenter, Scanner scanner, String clientName) {
        try {
            System.out.print("Въведете ID на артикул: ");
            int equipmentId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("От дата (yyyy-MM-dd): ");
            LocalDate from = LocalDate.parse(scanner.nextLine().trim());

            System.out.print("До дата (yyyy-MM-dd): ");
            LocalDate to = LocalDate.parse(scanner.nextLine().trim());

            String result = skiCenter.reserve(clientName, equipmentId, from, to);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Грешка: ID трябва да е цяло число.");
        } catch (DateTimeParseException e) {
            System.out.println("Грешка: некоректен формат на дата.");
        }
    }

    private static void handleMyReservations(SkiCenter skiCenter, String clientName) {
        String result = skiCenter.listReservationsForClient(clientName);
        System.out.println(result);
    }

    private static void handleCancelReservation(SkiCenter skiCenter, Scanner scanner, String clientName) {
        System.out.print("Въведете ID на резервацията за отмяна: ");
        try {
            int resId = Integer.parseInt(scanner.nextLine().trim());
            String result = skiCenter.cancelReservation(resId, clientName);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Грешка: ID трябва да е цяло число.");
        }
    }

    private static void printHelp() {
        System.out.println("HELP:");
        System.out.println("1) List available equipment for date - показва свободните артикули за конкретна дата.");
        System.out.println("2) Filter equipment - филтрира оборудване по тип и размер/диапазон.");
        System.out.println("3) Reserve equipment - създава резервация по ID и период.");
        System.out.println("4) Show my reservations - показва твоите резервации.");
        System.out.println("5) Cancel reservation - отменя твоя резервация по ID.");
        System.out.println("7) Exit - изход от програмата.");
    }
}
