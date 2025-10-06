/*Дадена е матрица NxM запълнена с цели числа. Разменете редовете с най-голям и най-малък елемент.*/
#include <limits.h>
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

    int maxNumber = INT_MIN, minNumber = INT_MAX;
    int biggestRow = 0, smallestRow = 0;
    for (int row = 0; row < firstMagicNumber; row++)
    {
        for (int col = 0; col < secondMagicNumber; col++)
        {
            if (magicArray[row][col] > maxNumber)
            {
                maxNumber = magicArray[row][col];
                biggestRow = row;
            }

            if (magicArray[row][col] < minNumber)
            {
                minNumber = magicArray[row][col];
                smallestRow = row;
            }
        }
    }

    int tempArray[firstMagicNumber][secondMagicNumber];
    for (int row = 0; row < firstMagicNumber; row++)
    {
        for (int col = 0; col < secondMagicNumber; col++)
        {
            tempArray[row][col] = magicArray[row][col];
        }
    }

    for (int row = 0; row < firstMagicNumber; row++)
    {
        for (int col = 0; col < secondMagicNumber; col++)
        {
            if (biggestRow == row)
            {
                magicArray[biggestRow][col] = tempArray[smallestRow][col];
            }
            if (smallestRow == row)
            {
                magicArray[smallestRow][col] = tempArray[biggestRow][col];
            }
        }
    }

    printf("\nNew matrix:\n");
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
