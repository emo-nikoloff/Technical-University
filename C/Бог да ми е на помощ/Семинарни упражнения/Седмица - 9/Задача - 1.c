/*Даден е двумерен масив NxM запълнен с цели числа. Проверете дали всеки ред съдържа числа, подредени в нарастващ ред, а всяка колона съдържа числа подредени в намаляващ ред.*/
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
            printf("Enter element at [%d][%d]: ", row, col);
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

    int isSorted = 1;
    for (int row = 0; row < firstMagicNumber; row++)
    {
        for (int col = 1; col < secondMagicNumber; col++)
        {
            if (magicArray[row][col] < magicArray[row][col - 1])
            {
                isSorted = 0;
                break;
            }
        }
        if (!isSorted)
            break;
    }

    if (isSorted)
    {
        for (int col = 0; col < secondMagicNumber; col++)
        {
            for (int row = 1; row < firstMagicNumber; row++)
            {
                if (magicArray[row][col] > magicArray[row - 1][col])
                {
                    isSorted = 0;
                    break;
                }
            }
            if (!isSorted)
                break;
        }
    }

    if (isSorted)
    {
        printf("True\n");
    }
    else
    {
        printf("False\n");
    }

    return 0;
}
