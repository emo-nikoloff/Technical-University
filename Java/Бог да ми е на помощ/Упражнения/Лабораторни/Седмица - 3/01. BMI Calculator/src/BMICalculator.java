import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) throws Exception {
        printIntroduction();

        for (int i = 1; i <= 1; i++) {
            getBMI();
        }
    }

    static void printIntroduction() {
        System.out.println("This program calculates your Body Mass Index (BMI).");
    }

    static double getBMI() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your weight in lbs:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter your height in inch:");
        int height = Integer.parseInt(scanner.nextLine());

        int weightInKg = (int) (weight / 2.2046);
        int heightInCentimeters = (int) (height * 0.3937);

        double BMI = bmiFor(weightInKg, heightInCentimeters);

        getStatus(BMI);

        return BMI;
    }

    static double bmiFor(int weightInKg, int heightInCentimeters) {
        return (weightInKg * 703 / (heightInCentimeters * heightInCentimeters));
    }

    static String getStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else if (bmi > 30) {
            return "Obese";
        }
        return "";
    }

    static void reportResults(int serialNumber, double index, String string) {
        System.out.println(serialNumber + ". BMI: " + index + " (" + string + ")");
    }
}
