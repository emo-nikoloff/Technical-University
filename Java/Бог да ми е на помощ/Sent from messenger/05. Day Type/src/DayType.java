// Напишете програма която, чете ден от седмицата. Ако денят е работен отпечатва на конзолата - "Working day", ако е почивен - "Weekend". Ако се въведе текст различен от ден от седмицата да се
// отпечата - "Error".

import java.util.Scanner;

public class DayType {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String day = input.nextLine();

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println("Working day");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Error");
                break;
        }

        input.close();
    }
}
