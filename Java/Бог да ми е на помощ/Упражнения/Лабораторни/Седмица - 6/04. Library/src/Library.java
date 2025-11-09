import java.util.List;
import java.util.ArrayList;

import Stockroom.Book;

public class Library {
    private List<Book> library;

    public Library() {
        this.library = new ArrayList<>();
    }

    public void addItem(Book book) {
        library.add(book);
    }

    public void searchByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();

        System.out.printf("Автор: %s%n", author);
        for (Book book : library) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
    }

    public void searchByGenre(String genre) {
        List<Book> foundBooks = new ArrayList<>();

        System.out.printf("Жанр: %s%n", genre);
        for (Book book : library) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                foundBooks.add(book);
            }
        }
    }

    public void borrowBook(String title) {

    }
}
