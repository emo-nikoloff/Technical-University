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
