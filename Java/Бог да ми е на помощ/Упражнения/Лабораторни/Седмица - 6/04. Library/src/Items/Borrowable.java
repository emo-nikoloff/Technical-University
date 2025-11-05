package Items;

public interface Borrowable {
    void borrowItem() throws BookNotAvailableException;

    void returnItem();
}
