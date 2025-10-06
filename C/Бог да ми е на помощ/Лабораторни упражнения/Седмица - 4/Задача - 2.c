/*Четем цяло число от клавиатурата и принтираме съобщение, ако остатъкът на числото при деление с 8 е по-голям от 4.*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter a number: ");
    scanf("%d", &magicNumber);

    if ((magicNumber % 8) > 4)
    {
        printf("The remainder %d of the number %d is bigger than 4", (magicNumber % 8), magicNumber);
    }
    else
    {
        printf("The remainder %d is not bigger than 4", (magicNumber % 8));
    }

    return 0;
}
