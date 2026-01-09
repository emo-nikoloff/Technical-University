public class Book extends Product {
    private String author;
    private String title;

    public Book() {

    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Book(int inventoryNumber, double price, int quantity, Provider provider, String author, String title) {
        super(inventoryNumber, price, quantity, provider);
        this.author = author;
        this.title = title;
    }

    @Override
    public double getPromotionalPrice() {
        double price = getPrice() - getPrice() * 0.5;
        return price;
    }

    @Override
    public boolean sellProduct(int piece) throws NoMoreProductException {
        return false;
    }
}
