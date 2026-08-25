/*Напишете програма, която намира максималния отрицателен елемент в горната триъгълна матрица на квадратна матрица 5x5. Елементите от второстепенния диагонал получават тази стойност.
Принтирайте новополучената матрица.*/
#include <limits.h>
#include <stdio.h>

int main(void)
{
    int matrix[5][5];
    for (int row = 0; row < 5; row++)
    {
        for (int col = 0; col < 5; col++)
        {
            printf("Enter element: ");
            scanf("%d", &matrix[row][col]);
        }
    }

    printf("Matrix:\n");
    for (int row = 0; row < 5; row++)
    {
        for (int col = 0; col < 5; col++)
        {
            printf("%d ", matrix[row][col]);
        }
        printf("\n");
    }

    int maxNegative = INT_MIN;
    for (int row = 0; row < 5; row++)
    {
        for (int col = 0; col < 5; col++)
        {
            if (col > row)
            {
                if (matrix[row][col] > maxNegative && matrix[row][col] < 0)
                {
                    maxNegative = matrix[row][col];
                }
            }
        }
    }

    if (maxNegative == INT_MIN)
    {
        printf("The are no negative numbers!!");
    }
    else
    {
        for (int row = 0; row < 5; row++)
        {
            for (int col = 0; col < 5; col++)
            {
                if (row + col == 5 - 1)
                {
                    matrix[row][col] = maxNegative;
                }
            }
        }

        printf("Swap the numbers in the minor diagonal with the max negative number:\n");
        for (int row = 0; row < 5; row++)
        {
            for (int col = 0; col < 5; col++)
            {
                printf("%d ", matrix[row][col]);
            }
            printf("\n");
        }
    }


    return 0;
}
