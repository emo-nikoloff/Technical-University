/*Дадена е редица с N цели числа. Да се намери K-тия по големина елемент в редицата.*/
#include <stdio.h>

int main(void)
{
    int magicNumber, magicChecker;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &magicNumber);
    printf("Check the biggest number in the array: ");
    scanf("%d", &magicChecker);

    if (magicNumber < magicChecker)
    {
        printf("The %d biggest number is out of range!!", magicChecker);
    }
    else
    {
        int array[magicNumber];
        for (int i = 0; i < magicNumber; i++)
        {
            printf("Enter element: ");
            scanf("%d", &array[i]);
        }

        for (int i = 0; i < magicNumber - 1; i++)
        {
            for (int j = 0; j < magicNumber - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        printf("The array sorted in ascending order:\n");
        for (int i = 0; i < magicNumber; i++)
        {
            printf("array[%d]: %d\n", i, array[i]);
        }

        int max = array[magicNumber - 1];
        int checker = 1;
        for (int i = magicNumber - 1; i > -1; i--)
        {
            if (array[i] < max)
            {
                checker++;
            }

            if (checker == magicChecker)
            {
                printf("The %d biggest number is: %d\n", magicChecker, array[i]);
                break;
            }
        }
    }

    return 0;
}
