/*Имаме квадратен числов масив nxn, n се въвежда от потребителя. Принтирайте елементите, които са на главния и второстепенния диагонал под формата на диагонал. Принтирайте също елементите,
които са над и под главния диагонал.*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter a number: ");
    scanf("%d", &magicNumber);

    int matrix[magicNumber][magicNumber];
    for (int row = 0; row < magicNumber; row++)
    {
        for (int col = 0; col < magicNumber; col++)
        {
            printf("Enter element: ");
            scanf("%d", &matrix[row][col]);
        }
    }

    printf("Matrix:\n");
    for (int row = 0; row < magicNumber; row++)
    {
        for (int col = 0; col < magicNumber; col++)
        {
            printf("%d ", matrix[row][col]);
        }
        printf("\n");
    }

    printf("The numbers in the main diagonal:\n");
    for (int row = 0; row < magicNumber; row++)
    {
        for (int col = 0; col < magicNumber; col++)
        {
            if (col == row)
            {
                printf("%d", matrix[row][col]);
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }

    printf("The numbers in the minor diagonal:\n");
    for (int row = 0; row < magicNumber; row++)
    {
        for (int col = 0; col < magicNumber; col++)
        {
            if (row + col == magicNumber - 1)
            {
                printf("%d", matrix[row][col]);
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }

    printf("The numbers above the main diagonal:\n");
    for (int row = 0; row < magicNumber; row++)
    {
        for (int col = 0; col < magicNumber; col++)
        {
            if (col > row)
            {
                printf("%d", matrix[row][col]);
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }

    printf("The numbers under the main diagonal:\n");
    for (int row = 0; row < magicNumber; row++)
    {
        for (int col = 0; col < magicNumber; col++)
        {
            if (col < row)
            {
                printf("%d", matrix[row][col]);
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}
