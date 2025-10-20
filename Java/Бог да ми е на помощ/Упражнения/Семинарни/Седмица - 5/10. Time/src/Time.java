/* Да се напише програма, която чете час и минути от 24-часово денонощие, въведени от потребителя, и изчислява колко ще е часът след 15 минути. Резултатът да се отпечата във формат часове:минути.
Часовете винаги са между 0 и 23, а минутите винаги са между 0 и 59. Часовете се изписват с една или две цифри. Минутите се изписват винаги с по две цифри, с водеща нула, когато е необходимо.*/

import java.util.Scanner;

public class Time {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter hour: ");
        int hour = Integer.parseInt(input.nextLine());
        System.out.print("Enter minutes: ");
        int minutes = Integer.parseInt(input.nextLine());

        while ((hour < 0 || hour > 23) || (minutes < 0 || minutes > 59)) {
            System.out.println("Enter valid time!");
            hour = Integer.parseInt(input.nextLine());
            minutes = Integer.parseInt(input.nextLine());
        }

        System.out.printf("The time now is %d:%02d%n", hour, minutes);

        minutes += 15;

        if (minutes > 59) {
            hour++;
            minutes -= 60;
        }

        if (hour > 23) {
            hour -= 24;
        }

        System.out.printf("After 15 minutes will be %d:%02d", hour, minutes);

        input.close();
    }
}
