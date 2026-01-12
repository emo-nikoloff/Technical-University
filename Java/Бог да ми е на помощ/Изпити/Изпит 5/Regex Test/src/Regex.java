import java.io.Serializable;

public class Regex implements Serializable {
    private int id;
    private String pattern;
    private String description;
    private int rating;
    private static int nextId = 0;

    public Regex(String pattern, String description) {
        this.pattern = pattern;
        this.description = description;
        this.rating = 0;
        this.id = nextId++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public static void setNextId(int nextId) {
        Regex.nextId = nextId;
    }

    public static int getNextId() {
        return nextId;
    }
}
