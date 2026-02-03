package Items;

public abstract class AudioItem {
    protected String genre;
    protected String duration;
    protected String category;
    protected String author;
    protected String year;

    public AudioItem(String genre, String duration, String category, String author, String year) {
        this.genre = genre;
        this.duration = duration;
        this.category = category;
        this.author = author;
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

}
