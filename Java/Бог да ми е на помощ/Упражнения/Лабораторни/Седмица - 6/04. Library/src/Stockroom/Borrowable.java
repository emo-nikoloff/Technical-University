package Stockroom;

public interface Borrowable {
    void borrowItem(Book book);

    void returnItem(Book book);
}
