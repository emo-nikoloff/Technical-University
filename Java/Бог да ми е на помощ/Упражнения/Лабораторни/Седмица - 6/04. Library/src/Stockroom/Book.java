package Stockroom;

public class Book extends Item {
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
}
