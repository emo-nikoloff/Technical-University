import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) throws Exception {
        try {
            FileWriter myWriter = new FileWriter("input.txt", false);
            myWriter.write("Jimmy is too old!");
            myWriter.close();
        } catch (IOException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
        }

        File myObj = new File("input.txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.printf("Старо съдържание: %s%n", data);
            }
        } catch (FileNotFoundException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
        }

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.replaceAll("old", "new");
                FileWriter myWriter = new FileWriter("output.txt", false);
                myWriter.write(data);
                myWriter.close();
                System.out.printf("Ново съдържание: %s%n", data);
            }
        } catch (FileNotFoundException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
        }
    }
}
