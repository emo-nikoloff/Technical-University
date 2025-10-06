/*Да се напише програма, която създава правоъгълна матрица с размер n на m. Размерността и стойностите за елементите се въвеждат от клавиатурата. Да се намери подматрица с размер 3х3, която има
максимална сума. Принтирайте подматрицата.*/
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

    for (int row = 0; row < firstMagicNumber; row++)
    {
        for (int col = 0; col < secondMagicNumber; col++)
        {
            for (int secondRow = 0; secondRow < 3; secondRow++)
            {
                for (int secondCol = 0; secondCol < 3; secondCol++)
                {

                }
            }
        }
    }

    return 0;
}
