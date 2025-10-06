/*Потребителят въвежда низ, след което въвежда единичен символ. Проверете колко пъти се среща символът в низа.*/
#include <stdio.h>
#include <string.h>

int main(void)
{
    char string[50], symbol;
    printf("Enter a string:\n");
    scanf("%[^\n]", string);
    printf("Search for a symbol:\n");
    scanf(" %c", &symbol);
    printf("The string is: %s\n", string);
    printf("The searched symbol is: %c\n", symbol);

    int counter = 0;
    for (int i = 0; i < strlen(string); i++)
    {
        if (string[i] == symbol)
        {
            counter++;
        }
    }
    printf("The symbol %c can be found %d times.\n", symbol, counter);

    return 0;
}
