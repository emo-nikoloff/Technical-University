/*1. Създайте клас BMICalculator.
2. Създайте и имплементирайте метод printIntroduction() – той ще се извиква всеки път при стартиране на програмата. Той ще трябва да информира потребителя какво прави програмата, която е пуснал.
3. Създайте метод getBMI(), който ще „поиска“ и ще „събере“ информация от потребителя за неговото тегло и височина. Нека да приема като аргумент Scanner, който чете от клавиатурата.
В имплементацията на метода ще трябва да подканите потребителя да въведе височината си в инчове(За да си пресметнете височината използвайте, че 1см.= 0.3937 inch)
и теглото си в паунди(използвайте формулата: kg = lb / 2,2046). Нека за сега методът ви връща void.
4. Създайте метод bmiFor(), който по подадени тегло и височина, изчислява body mass index и го връща като резултат. Формулата за индекса е: weight*703/ (height*height).
5. Направете така, че методът getBMI() да връща като резултат, резултатът, който връща методът bmiFor().
6. Направете метод getStatus(). Той трябва да връща като резултат един от символните низове: underweight, normal, overweight, obese. По статистики на център за здраве, тези 4 характеристики се
дават съответно ако: индексът е не повече от 18,5, ако индексът е не повече от 25, ако индексът е не повече от 30 и ако е над 30.
7. Създайте метод ReportResults, който приема като параметри: пореден номер на резултата, BMI индекс, статус. Той трябва да изведе на конзолата подходящо съобщение, с което уведомява, че човекът
с номер Х има BMI= х.х, закръглен до втория знак. За закръглянето изпозлвайте Math.round(BMI);
8. В main метод на програмата създайте Scanner, който чете от стандартен вход, подайте го към getBM(), после по върнатия от него резултат вземете статуса с метод getStatus() и извикайте метода
reportResults(), за да изведете даннитe.*/

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