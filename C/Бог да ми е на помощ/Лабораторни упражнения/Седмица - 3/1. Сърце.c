/*Изчертайте сърце със символ, който се чете от потребителя.*/
#include <stdio.h>

int main(void)
{
    char symbol;
    printf("Enter symbol: ");
    scanf("%c", &symbol);

    printf(" %c", symbol);
    printf("  %c\n", symbol);
    printf("%c", symbol);
    printf("%c", symbol);
    printf("%c", symbol);
    printf("%c", symbol);
    printf("%c", symbol);
    printf("%c\n", symbol);
    printf(" %c", symbol);
    printf("%c", symbol);
    printf("%c", symbol);
    printf("%c\n", symbol);
    printf("  %c", symbol);
    printf("%c", symbol);

    return 0;
}
