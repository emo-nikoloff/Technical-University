/*Да се напише програма, която намира последователност от числа в масив, които имат сума равна на число, въведено от потребителя (ако има такава).*/
#include <stdio.h>

int main(void)
{
    int magicNumber, magicSum;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &magicNumber);
    printf("Enter the target sum: ");
    scanf("%d", &magicSum);

    int array[magicNumber];
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Enter element: ");
        scanf("%d", &array[i]);
    }

    printf("The array:\n");
    for (int i = 0; i < magicNumber; i++)
    {
        printf("array[%d]: %d\n", i, array[i]);
    }

    int currentSum = 0, index = 0;
    int sumArray[magicNumber];
    for (int i = 0; i < magicNumber; i++)
    {
        currentSum += array[i];
        sumArray[index] = array[i];
        index++;
        if (currentSum > magicSum)
        {
            currentSum = 0, index = 0;
            currentSum += array[i];
            sumArray[index] = array[i];
            index++;
        }
        else if (currentSum == magicSum)
        {
            printf("You achieved the sum!!\nThese are the numbers:\n");
            for (int j = 0; j < index; j++)
            {
                if (j == 0)
                {
                    printf("%d +", sumArray[j]);
                }
                else if (j == index - 1)
                {
                    printf(" %d = %d", sumArray[j], magicSum);
                }
                else
                {
                    printf(" %d +", sumArray[j]);
                }
            }
            break;
        }
    }

    return 0;
}
