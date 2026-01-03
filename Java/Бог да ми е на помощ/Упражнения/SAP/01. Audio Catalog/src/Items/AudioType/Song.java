package Items.AudioType;

import Items.AudioItem;

public class Song extends AudioItem {
    private String title;

    public Song(String title, String genre, String duration, String category, String author, String year) {
        this.title = title;
        super(genre, duration, category, author, year);
    }

    public String getTitle() {
        return title;
    }
}
