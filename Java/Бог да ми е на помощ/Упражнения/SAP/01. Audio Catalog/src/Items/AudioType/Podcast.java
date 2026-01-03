package Items.AudioType;

import Items.AudioItem;

public class Podcast extends AudioItem {
    private String title;

    public Podcast(String title, String genre, String duration, String category, String author, String year) {
        this.title = title;
        super(genre, duration, category, author, year);
    }

    public String getTitle() {
        return title;
    }
}
