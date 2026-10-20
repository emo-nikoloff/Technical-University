#include <iostream>
#include <string>

using namespace std;

class Book
{
private:
    string title;
    string author;
    int pages;

public:
    Book(string title, string author, int pages)
    {
        this->title = title;
        this->author = author;
        this->pages = pages;
    }

    void print()
    {
        cout << "Title: " << title << '\n';
        cout << "Author: " << author << '\n';
        cout << "Pages: " << pages << '\n';
        cout << '\n';
    }
};

int main()
{
    Book book1("The Hobbit", "J. R. R. Tolkien", 310);
    Book *book2 = new Book("1984", "George Orwell", 328);

    book1.print();
    book2->print();

    delete book2;
    book2 = nullptr;

    return 0;
}
