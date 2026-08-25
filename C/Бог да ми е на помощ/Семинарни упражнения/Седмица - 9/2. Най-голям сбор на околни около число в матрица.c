/*Даден е масив NxM запълнен с цели числа. Намерете числото, което има околни на него сбора, на които е най-голям.
(околно е всяко число което се намира до, над, под или по диагонал на текущото на отстояние не повече от 1 поле).*/
#include <stdio.h>

int main(void)
{
    int firstMagicNumber, secondMagicNumber;
    printf("Enter the first magic number: ");
    scanf("%d", &firstMagicNumber);
    printf("Enter the second magic number: ");
    scanf("%d", &secondMagicNumber);

    int magicArray[firstMagicNumber][secondMagicNumber];
    for (int row = 0; row < firstMagicNumber; row++)
    {
        for (int col = 0; col < secondMagicNumber; col++)
        {
            printf("Enter element: ");
            scanf("%d", &magicArray[row][col]);
        }
    }

    printf("Matrix:\n");
    for (int row = 0; row < firstMagicNumber; row++)
    {
        for (int col = 0; col < secondMagicNumber; col++)
        {
            printf("%d ", magicArray[row][col]);
        }
        printf("\n");
    }

    return 0;
}
