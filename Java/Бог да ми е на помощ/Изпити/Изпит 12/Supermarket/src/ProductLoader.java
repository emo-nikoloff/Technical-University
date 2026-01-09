import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ProductLoader implements ImportData {
    private static final String SALESPRODUCTS_FILENAME = "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Изпити\\fsdfsd\\Magazin\\src\\salesproducts.txt";

    private long getNumberOfRows() throws IOException {
        long counter = Files.lines(Path.of(SALESPRODUCTS_FILENAME)).count();
        return counter;
    }

    @Override
    public Object[] importDataFromFile() throws IOException {
        Product[] products = new Product[(int) getNumberOfRows()];
        Scanner objectScan = new Scanner(new File(SALESPRODUCTS_FILENAME));

        for (int i = 0; i < products.length; i++) {
            String object = objectScan.nextLine();
            String[] objectParts = object.split("#");

            String typeObject = objectParts[0];
            String providerName = objectParts[1];
            String phoneNumber = objectParts[2];
            Provider provider = new Provider(providerName, phoneNumber);
            int inventoryNumber = Integer.parseInt(objectParts[3]);
            Double price = Double.parseDouble(objectParts[4]);
            int quantity = Integer.parseInt(objectParts[5]);
            String creator = objectParts[6];
            String creation = objectParts[7];

            switch (typeObject) {
                case "1":
                    Electronics el = new Electronics(inventoryNumber, price, quantity, provider, creator, creation);
                    products[i] = el;
                    break;
                case "2":
                    Book book = new Book(inventoryNumber, price, quantity, provider, creator, creation);
                    products[i] = book;
                    break;
                default:
                    throw new IOException();
            }
        }

        objectScan.close();

        return products;
    }

}
