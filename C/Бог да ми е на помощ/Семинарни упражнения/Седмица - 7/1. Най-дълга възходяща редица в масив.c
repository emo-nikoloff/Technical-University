/*Всяка редица от равни числа в едномерен сортиран масив, се нарича площадка. Да се напише програма, която намира началото и дължината на най-дългата площадка в даден сортиран
във възходящ ред едномерен масив (въвеждат се N и самият масив от потребителя).*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter number of elements: ");
    scanf("%d", &magicNumber);

    int array[magicNumber];
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Enter element: ");
        scanf("%d", array + i);
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

    int maxLength = 1, currentLength = 1;
    int maxStartIndex = 0, currentStartIndex = 0;
    for (int i = 1; i < magicNumber; i++)
    {
        if (array[i] == array[i - 1])
        {
            currentLength++;
            if (currentLength > maxLength)
            {
                maxLength = currentLength;
                maxStartIndex = currentStartIndex;
            }
        }
        else
        {
            currentLength = 1;
            currentStartIndex = i;
        }
    }

    if (currentLength != maxLength)
    {
        printf("Longest platform starts at index %d and has length %d\n", maxStartIndex, maxLength);
    }
    else
    {
        printf("There isn't a longer platform\n");
    }

    return 0;
}
