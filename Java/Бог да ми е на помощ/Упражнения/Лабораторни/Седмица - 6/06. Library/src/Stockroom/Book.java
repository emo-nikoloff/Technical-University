package Stockroom;

public class Book extends Item implements Borrowable {
    private String genre;
    private boolean available;

    public Book(String title, String author, int year, String genre) {
        super(title, author, year);
        this.genre = genre;
        this.available = true;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrowItem() {
        if (available) {
            available = false;
            System.out.printf("Заехте книгата \"%s\"%n", title);
        } else {
            System.out.printf("Книгата \"%s\" вече е заета!%n", title);
        }
    }

    @Override
    public void returnItem() {
        if (!available) {
            available = true;
            System.out.printf("Върнахте книгата \"%s\"%n", title);
        } else {
            System.out.printf("Книгата \"%s\" не е била взимана!%n", title);
        }
    }
}
