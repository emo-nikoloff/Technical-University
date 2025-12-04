/*Създайте абстрактен клас Item, който съдържа следните характеристики: title – низ, съдържащ името на книгата, author – низ съдържащ името на автора,
year – цяло число, показващо годината на издаване на книгата. Класът трябва да съдържа конструктор с параметри и метод за достъп до характеристиките. Създайте клас Book, който наследява класа
Item. Този клас трябва да има допълнителни характеристики: genre – низ, съдържащ жанра на книгата (например: роман, научна фантастика, исторически), available – булева стойност, която показва
дали книгата е налична или в момента е взета от читател. Създайте интерфейс Borrowable, който да съдържа два метода: borrowItem() – метод, който ще се извиква, когато читател иска да вземе
книгата. Ако книгата е налична, статусът ѝ трябва да стане "взета" (available = false). Ако вече е взета, хвърлете изключение. И метод returnItem() – метод, който ще се извиква, когато читател
връща книгата. Статусът на книгата трябва да стане "налична" (available = true). Създайте клас Library, който ще съдържа списък с книги и ще има следните методи: addItem(Book book) - метод,
който добавя книга към библиотеката, searchByAuthor(String author) - метод, който връща списък с всички книги от даден автор, searchByGenre(String genre) - метод, който връща списък с всички
книги от даден жанр. Метод borrowBook(String title) - метод, който ще търси книга по заглавие и ще я заеме, използвайки метода borrowItem() от интерфейса Borrowable.*/

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
