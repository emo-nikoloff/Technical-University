package Items;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addItem(Book book) {
        this.books.add(book);
        System.out.println("Добавена книга: " + book.getTitle());
    }

    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public void borrowBook(String title) {
        Book bookToBorrow = books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);

        if (bookToBorrow != null) {
            try {
                bookToBorrow.borrowItem();
            } catch (BookNotAvailableException e) {
                System.err.println("Грешка при заемане: " + e.getMessage());
            }
        } else {
            System.err.println("Книга със заглавие \"" + title + "\" не е намерена.");
        }
    }

    public void returnBook(String title) {
        Book bookToReturn = books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);

        if (bookToReturn != null) {
            bookToReturn.returnItem();
        } else {
            System.err.println("Книга със заглавие \"" + title + "\" не е намерена.");
        }
    }

    public void displayAllBooks() {
        System.out.println("\n--- ЦЯЛ СПИСЪК С КНИГИ ---");
        books.forEach(System.out::println);
        System.out.println("--------------------------");
    }
}