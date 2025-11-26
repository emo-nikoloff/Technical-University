import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Searcher {
    public static void main(String[] args) throws Exception {
        File myFile = new File(
                "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Упражнения\\Лабораторни\\Седмица - 8\\02. Words Searching\\src\\data\\words.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.matches("app\\w+")) {
                    System.out.println(line);
                }
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
