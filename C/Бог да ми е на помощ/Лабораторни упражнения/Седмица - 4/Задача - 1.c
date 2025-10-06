/*Четем цяло число от клавиатурата и принтираме дали е по-голямо, по-малко или равно на 20.*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter a number: ");
    scanf("%d", &magicNumber);

    if (magicNumber > 20)
    {
        printf("The number %d is bigger than 20", magicNumber);
    }
    else if (magicNumber < 20)
    {
        printf("The number %d is smaller than 20", magicNumber);
    }
    else
    {
        printf("The number %d is equal to 20", magicNumber);
    }

    return 0;
}
