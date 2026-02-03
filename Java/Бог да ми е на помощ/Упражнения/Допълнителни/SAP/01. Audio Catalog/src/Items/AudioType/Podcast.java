package Items.AudioType;

import Items.AudioItem;

public class Podcast extends AudioItem {
    private String title;

    public Podcast(String title, String genre, String duration, String category, String author, String year) {
        super(genre, duration, category, author, year);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
