import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Searcher {
    public static void main(String[] args) throws Exception {
        File myObj = new File("words.txt");

        try (Scanner myReader = new Scanner(myObj)) {
            System.out.println("Съдържание на файла:");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
        }

        try (Scanner myReader = new Scanner(myObj)) {
            System.out.println("\nДуми започващи с 'app':");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.matches("app\\w+")) {
                    System.out.println(data);
                }
            }
        } catch (FileNotFoundException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
        }
    }
}
