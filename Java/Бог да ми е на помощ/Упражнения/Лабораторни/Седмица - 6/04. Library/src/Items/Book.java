package Items;

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
    public void borrowItem() throws BookNotAvailableException {
        if (!available) {
            throw new BookNotAvailableException("Книгата \"" + getTitle() + "\" вече е заета.");
        }
        available = false;
        System.out.println("Книгата \"" + getTitle() + "\" е успешно заета.");
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("Книгата \"" + getTitle() + "\" е успешно върната.");
    }

    @Override
    public String toString() {
        return String.format("%s (%d) от %s. Жанр: %s. Статус: %s",
                getTitle(), getYear(), getAuthor(), genre,
                available ? "Налична" : "Заета");
    }
}