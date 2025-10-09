import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        printIntroduction();

        for (int i = 1; i <= 1; i++) {
            double bmi = getBMI(input);
            String status = getStatus(bmi);
            reportResults(i, bmi, status);
        }

        input.close();
    }

    static void printIntroduction() {
        System.out.println("This program calculates your Body Mass Index (BMI).");
    }

    static double getBMI(Scanner input) {
        System.out.print("Enter your weight in kg: ");
        double weight = Integer.parseInt(input.nextLine());
        System.out.print("Enter your height in cm: ");
        double height = Integer.parseInt(input.nextLine());

        double weightLb = weight * 2.2046;
        double heightInch = height * 0.3937;

        double BMI = bmiFor(weightLb, heightInch);

        return BMI;
    }

    static double bmiFor(double weight, double height) {
        return (weight * 703 / (height * height));
    }

    static String getStatus(double bmi) {
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi <= 25) {
            return "Normal";
        } else if (bmi <= 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void reportResults(int serialNumber, double bmiIndex, String status) {
        double roundedBmi = Math.round(bmiIndex * 100.0) / 100.0;
        System.out.println("Person №" + serialNumber + " has BMI = " + roundedBmi + " -> " + status);
    }
}