package Items.AudioType;

import Items.AudioItem;

public class Song extends AudioItem {
    private String title;

    public Song(String title, String genre, String duration, String category, String author, String year) {
        super(genre, duration, category, author, year);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
