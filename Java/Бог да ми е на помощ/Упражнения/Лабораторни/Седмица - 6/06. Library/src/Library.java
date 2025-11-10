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

    public List<Book> searchByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();

        System.out.printf("Автор: %s%n", author);
        for (Book book : library) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }

    public List<Book> searchByGenre(String genre) {
        List<Book> foundBooks = new ArrayList<>();

        System.out.printf("Жанр: %s%n", genre);
        for (Book book : library) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }

    public void borrowBook(String title) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.borrowItem();
                return;
            }
        }
        System.out.printf("Книгата \"%s\" не е намерена!%n", title);
    }

    public void returnBook(String title) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.returnItem();
                return;
            }
        }
        System.out.printf("Книгата \"%s\" не е намерена!%n", title);
    }

    public void displayBooks() {
        System.out.println("Списък с книгите:");
        for (Book book : library) {
            System.out.printf("-> %s - %s - %d - %s - ", book.getTitle(), book.getAuthor(), book.getYear(),
                    book.getGenre());
            if (book.isAvailable()) {
                System.out.println("налична");
            } else {
                System.out.println("неналична");
            }
        }
    }
}
