/*Да се напише програма за обработка на информация за 5 книги. За всяка книга се въвежда информация за:
-> заглавие на книга (char [])
-> автор (char [])
-> година на издаване (int)
-> цена (double)
Да се реализират отделни функции:
- за въвеждане на информацията за книгите
- за извеждане на информацията за всички книги, издадени след 2005 година
- за търсене на книги по име на автор, което се задава от потребителя.*/
#include <stdio.h>
#include <string.h>

struct Book
{
    char title[50];
    char author[50];
    int yearRelease;
    double price;
};

void booksList(struct Book books[5])
{
    for (int i = 0; i < 5; i++)
    {
        printf("Enter book #%d title: ", i + 1);
        scanf("%[^\n]", books[i].title);
        printf("Enter book #%d author: ", i + 1);
        scanf("%[^\n]", books[i].author);
        printf("Enter book #%d release year: ", i + 1);
        scanf("%d", &books[i].yearRelease);
        printf("Enter book #%d price: ", i + 1);
        scanf("%lf", &books[i].price);
    }

    printf("The books:\n");
    for (int i = 0; i < 5; i++)
    {
        printf("Book #%d title: %s\n", i + 1, books[i].title);
        printf("Book #%d author: %s\n", i + 1, books[i].author);
        printf("Book #%d release year: %d\n", i + 1, books[i].yearRelease);
        printf("Book #%d price: %.2lf\n\n", i + 1, books[i].price);
    }
}

void booksAfter2005(struct Book books[5])
{
    printf("The books after 2005:\n");
    int counter = 0;
    for (int i = 0; i < 5; i++)
    {
        if (books[i].yearRelease > 2005)
        {
            printf("Book #%d title: %s\n", i + 1, books[i].title);
            printf("Book #%d author: %s\n", i + 1, books[i].author);
            printf("Book #%d release year: %d\n", i + 1, books[i].yearRelease);
            printf("Book #%d price: %.2lf\n\n", i + 1, books[i].price);
            counter++;
        }
    }

    if (counter == 0)
    {
        printf("No books after 2005:\n\n");
    }
}

void searchAuthor(struct Book books[5], char author[])
{
    printf("Search for books from this author: ");
    scanf("%[^\n]", author);

    printf("Author: %s\n", author);
    int isFound = 0;
    for (int i = 0; i < 5; i++)
    {
        if (strcmp(books[i].author, author))
        {
            printf("Book #%d title: %s\n", i + 1, books[i].title);
            printf("Book #%d release year: %d\n", i + 1, books[i].yearRelease);
            printf("Book #%d price: %.2lf\n\n", i + 1, books[i].price);
            isFound = 1;
        }
    }

    if (isFound == 0)
    {
        printf("No books from the author are found.\n\n");
    }
}

int main()
{
    struct Book books[5];
    booksList(books);
    booksAfter2005(books);

    char author[50];
    searchAuthor(books, author);
}
