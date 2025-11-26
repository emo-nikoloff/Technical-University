import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Analyze {
    public static void main(String[] args) throws Exception {
        File myFile = new File(
                "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Упражнения\\Лабораторни\\Седмица - 8\\03. Analyze CSV Files\\src\\data\\people.csv");

        int totalAge = 0;
        int countPeople = 0;
        int countSofia = 0;
        int countPlovdiv = 0;
        int countSilistra = 0;
        int countAytos = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                // String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String city = parts[2];

                totalAge += age;
                countPeople++;

                if (city.equalsIgnoreCase("София")) {
                    countSofia++;
                }

                if (city.equalsIgnoreCase("Пловдив")) {
                    countPlovdiv++;
                }
                if (city.equalsIgnoreCase("Силистра")) {
                    countSilistra++;
                }

                if (city.equalsIgnoreCase("Айтос")) {
                    countAytos++;
                }
            }
            double averageAge = totalAge / countPeople;

            System.out.printf("Средна възраст: %d%n", (int) averageAge);
            System.out.printf("Брой хора от София: %d%n", countSofia);
            System.out.printf("Брой хора от Пловдив: %d%n", countPlovdiv);
            System.out.printf("Брой хора от Силистра: %d%n", countSilistra);
            System.out.printf("Брой хора от Айтос: %d%n", countAytos);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
