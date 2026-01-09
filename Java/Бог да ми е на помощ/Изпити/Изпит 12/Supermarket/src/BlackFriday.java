public class BlackFriday {
    public static Electronics[] electronics;
    public static Book[] books;

    public static void processSales() {
        ProductLoader loader = new ProductLoader();
        int countElectronics = 0;
        int countBooks = 0;
        try {
            Object[] productsForSale = loader.importDataFromFile();
            for (int i = 0; i < productsForSale.length; i++) {
                if (productsForSale[i] instanceof Electronics) {
                    countElectronics++;
                } else if (productsForSale[i] instanceof Book) {
                    countBooks++;
                }
            }

            electronics = new Electronics[countElectronics];
            int electronicsIndex = 0;

            books = new Book[countBooks];
            int booksIndex = 0;

            for (int i = 0; i < productsForSale.length; i++) {
                if (productsForSale[i] instanceof Electronics) {
                    electronics[electronicsIndex] = (Electronics) productsForSale[i];
                    electronicsIndex++;
                } else if (productsForSale[i] instanceof Book) {
                    books[booksIndex] = (Book) productsForSale[i];
                    booksIndex++;
                }
            }
        } catch (Exception error) {
            error.printStackTrace();
        }

    }
}
