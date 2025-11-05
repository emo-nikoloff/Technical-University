import java.util.List;

import Items.Book;
import Items.Library;

public class App {
    public static void main(String[] args) throws Exception {
        Library library = new Library();

        library.addItem(new Book("Dune", "Frank Herbert", 1965, "Фантастика"));
        library.addItem(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "Фентъзи"));
        library.addItem(new Book("1984", "George Orwell", 1949, "Дистопия"));
        library.addItem(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Фентъзи"));

        library.displayAllBooks();

        System.out.println("\n--- Търсене по автор: J.R.R. Tolkien ---");
        List<Book> tolkienBooks = library.searchByAuthor("J.R.R. Tolkien");
        tolkienBooks.forEach(System.out::println);

        System.out.println("\n--- Търсене по жанр: Фентъзи ---");
        List<Book> fantasyBooks = library.searchByGenre("Фентъзи");
        fantasyBooks.forEach(System.out::println);

        System.out.println("\n--- Демонстрация на заемане ---");
        library.borrowBook("Dune");

        library.borrowBook("Dune");

        library.returnBook("Dune");

        library.displayAllBooks();
    }
}
