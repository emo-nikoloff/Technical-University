/*Напишете програма, която отпечатва рамка с размер 10х5 изградена от знак, въведен от потребителя: "-".*/
#include <stdio.h>

int main()
{
    char symbol;
    printf("Enter symbol: ");
    scanf("%c", &symbol);

    printf("%c%c%c%c%c%c%c%c%c%c\n", symbol, symbol, symbol, symbol, symbol, symbol, symbol, symbol, symbol, symbol);
    printf("%c\t %c\n", symbol, symbol);
    printf("%c\t %c\n", symbol, symbol);
    printf("%c\t %c\n", symbol, symbol);
    printf("%c%c%c%c%c%c%c%c%c%c\n", symbol, symbol, symbol, symbol, symbol, symbol, symbol, symbol, symbol, symbol);

    return 0;
}
