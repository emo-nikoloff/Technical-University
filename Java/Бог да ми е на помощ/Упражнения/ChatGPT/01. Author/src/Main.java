import AuthorBook.Book;
import AuthorBook.Library;

public class Main {
    public static void main(String[] args) throws Exception {
        Library library = new Library(5);

        Book book1 = new Book("Малкият принц", "Антоан дьо Сент-Екзюпери", 1943);
        Book book2 = new Book("Под игото", "Иван Вазов", 1894);
        Book book3 = new Book("1984", "Джордж Оруел", 1949);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.listBooks();

        System.out.println("Търсене на книга '1984':");
        Book found = library.searchByTitle("1984");
        if (found != null) {
            found.displayInfo();
        }

        library.borrowBook("1984");

        System.out.println();

        library.listBooks();
    }
}
