/*Имаме двумерен масив с размерност 4x5. Изчисляваме сумите от елемнтите по редове. Намираме минималната сред тях, след което извеждаме масива, като притнираме сумата за съответния ред.*/
#include <limits.h>
#include <stdio.h>

int main(void)
{
    int matrix[4][5];
    for (int row = 0; row < 4; row++)
    {
        for (int col = 0; col < 5; col++)
        {
            printf("Enter value for matrix[%d][%d]:", row, col);
            scanf("%d", &matrix[row][col]);
        }
    }

    int minSum = INT_MAX;
    printf("Matrix:\n");
    for (int row = 0; row < 4; row++)
    {
        int sum = 0;
        for (int col = 0; col < 5; col++)
        {
            printf("%d ", matrix[row][col]);
            sum += matrix[row][col];
        }

        if (sum < minSum)
        {
            minSum = sum;
        }

        printf("= %d\n", sum);
    }
    printf("Minimum sum = %d\n", minSum);
}
