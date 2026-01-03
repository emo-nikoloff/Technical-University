package Items.AudioType;

import Items.AudioItem;

public class Album extends AudioItem {
    private String title;

    public Album(String title, String genre, String duration, String category, String author, String year) {
        this.title = title;
        super(genre, duration, category, author, year);
    }

    public String getTitle() {
        return title;
    }
}
