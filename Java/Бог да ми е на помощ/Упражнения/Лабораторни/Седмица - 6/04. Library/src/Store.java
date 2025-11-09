import java.util.List;

import Stockroom.Book;

public class Store {
    public static void main(String[] args) throws Exception {
        Library library = new Library();

        Book book1 = new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954, "Fantasy");
        Book book2 = new Book("Dune", "Frank Herbert", 1965, "Science fiction");
        Book book3 = new Book("Darkly Dreaming Dexter", "Jeff Lindsay", 2004, "Crime/Thriller");
        Book book4 = new Book("The Hobbit", "J. R. R. Tolkien", 1937, "Fantasy");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);

        library.displayBooks();

        System.out.printf("\nТърсене по автор:%n");
        List<Book> tolkienBooks = library.searchByAuthor("J. R. R. Tolkien");
        System.out.println("Книги:");
        for (Book book : tolkienBooks) {
            System.out.printf("-> %s%n", book.getTitle());
        }

        System.out.printf("\nТърсене по жанр:%n");
        List<Book> fantasyBooks = library.searchByGenre("Fantasy");
        System.out.println("Книги:");
        for (Book book : fantasyBooks) {
            System.out.printf("-> %s%n", book.getTitle());
        }

        System.out.println();

        library.borrowBook("The Hobbit");
        library.borrowBook("Момиче за милиони");

        library.returnBook("The Hobbit");
        library.returnBook("Момиче за милиони");

        library.borrowBook("Dune");

        System.out.println();

        library.displayBooks();
    }
}
