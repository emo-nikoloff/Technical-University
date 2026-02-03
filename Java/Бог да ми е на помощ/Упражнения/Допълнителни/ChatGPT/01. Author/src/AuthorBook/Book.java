package AuthorBook;

public class Book {
    private String Title;
    private String Author;
    private int Year;
    private boolean Availability;

    public Book(String title, String author, int year) {
        this.Title = title;
        this.Author = author;
        this.Year = year;
        this.Availability = true;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public String getAuthor() {
        return Author;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public int getYear() {
        return Year;
    }

    public void setAvailability(boolean availability) {
        this.Availability = availability;
    }

    public boolean isAvailable() {
        return Availability;
    }

    public void displayInfo() {
        System.out.println("Заглавие: " + Title);
        System.out.println("Автор: " + Author);
        System.out.println("Година: " + Year);
        System.out.println("Налична: " + (Availability ? "Да" : "Не"));
        System.out.println("--------------------");
    }

}
