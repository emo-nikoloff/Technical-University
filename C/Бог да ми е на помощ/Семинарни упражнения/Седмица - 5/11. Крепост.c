/*Да се напише програма, която прочита от конзолата цяло число n, въведено от потребителя, и чертае крепост с ширина 2*n и височина n реда. Лявата и дясната колона във вътрешността си са
широки n/2.*/
#include <stdio.h>

int main()
{
    int n;
    scanf("%d", &n);

    int middleSpaces = 2 * n - 2 * (n / 2) - 4;

    printf("/");
    for (int i = 0; i < n / 2; i++)
        printf("^");
    printf("\\");
    for (int i = 0; i < middleSpaces; i++)
        printf("_");
    printf("/");
    for (int i = 0; i < n / 2; i++)
        printf("^");
    printf("\\\n");

    for (int i = 0; i < n - 3; i++)
    {
        printf("|");
        for (int j = 0; j < 2 * n - 2; j++)
            printf(" ");
        printf("|\n");
    }

    if (n > 2)
    {
        printf("|");
        for (int i = 0; i < n / 2 + 1; i++)
            printf(" ");
        for (int i = 0; i < middleSpaces; i++)
            printf("_");
        for (int i = 0; i < n / 2 + 1; i++)
            printf(" ");
        printf("|\n");
    }

    printf("\\");
    for (int i = 0; i < n / 2; i++)
        printf("_");
    printf("/");
    for (int i = 0; i < middleSpaces; i++)
        printf(" ");
    printf("\\");
    for (int i = 0; i < n / 2; i++)
        printf("_");
    printf("/\n");

    return 0;
}
