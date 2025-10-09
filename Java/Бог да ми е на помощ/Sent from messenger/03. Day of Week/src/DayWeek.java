// Напишете програма, която чете цяло число, въведено от потребителя, и отпечатва ден от седмицата , в граници 1-7 или отпечатва "Error" в случай, че въведеното число е невалидно.

import java.util.Scanner;

public class DayWeek {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int day = Integer.parseInt(input.nextLine());

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Error");
                break;
        }

        input.close();
    }
}
