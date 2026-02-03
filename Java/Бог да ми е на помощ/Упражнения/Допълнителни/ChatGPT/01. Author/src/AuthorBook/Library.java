package AuthorBook;

public class Library {
    private Book[] Books;
    private int Count;

    public Library(int capacity) {
        Books = new Book[capacity];
        Count = 0;
    }

    public void addBook(Book book) {
        if (Count < Books.length) {
            Books[Count] = book;
            Count++;
        } else {
            System.out.println("Библиотеката е пълна!");
        }
    }

    public void listBooks() {
        System.out.println("Списък с книги:");
        for (int i = 0; i < Count; i++) {
            Books[i].displayInfo();
        }
    }

    public Book searchByTitle(String title) {
        for (int i = 0; i < Count; i++) {
            Book book = Books[i];
            String bookTitle = book.getTitle();

            if (bookTitle.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title) {
        Book book = searchByTitle(title);

        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailability(false);
                System.out.println("Вие заехте книгата: " + title);
            } else {
                System.out.println("Книгата вече е заета.");
            }
        } else {
            System.out.println("Няма такава книга.");
        }
    }

    public void returnBook(String title) {
        Book book = searchByTitle(title);

        if (book != null) {
            if (!book.isAvailable()) {
                book.setAvailability(true);
                System.out.println("Вие върнахте книгата: " + title);
            } else {
                System.out.println("Тази книга не е била заета.");
            }
        } else {
            System.out.println("Няма такава книга.");
        }
    }
}
