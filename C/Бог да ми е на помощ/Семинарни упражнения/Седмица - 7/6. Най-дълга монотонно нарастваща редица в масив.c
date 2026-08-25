/*За дадена редица от числа да се намери и отпечата най-дългата монотонно нарастваща/намаляваща подредица.*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &magicNumber);

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

    int maxAscending = 1, maxDescending = 1;
    int ascending = 1, descending = 1;
    int startAscending = 0, maxStartAscending = 0;
    int startDescending = 0, maxStartDescending = 0;
    for (int i = 1; i < magicNumber; i++)
    {
        if (array[i] > array[i - 1])
        {
            ascending++;
        }
        else
        {
            if (ascending > maxAscending)
            {
                maxAscending = ascending;
                maxStartAscending = startAscending;
            }
            ascending = 1;
            startAscending = i;
        }

        if (array[i] < array[i - 1])
        {
            descending++;
        }
        else
        {
            if (descending > maxDescending)
            {
                maxDescending = descending;
                maxStartDescending = startDescending;
            }
            descending = 1;
            startDescending = i;
        }
    }

    if (ascending > maxAscending)
    {
        maxAscending = ascending;
        maxStartAscending = startAscending;
    }
    if (descending > maxDescending)
    {
        maxDescending = descending;
        maxStartDescending = startDescending;
    }

    printf("Longest increasing subsequence:\n");
    for (int i = maxStartAscending; i < maxStartAscending + maxAscending; i++)
    {
        printf("%d ", array[i]);
    }
    printf("\n");

    printf("Longest decreasing subsequence:\n");
    for (int i = maxStartDescending; i < maxStartDescending + maxDescending; i++)
    {
        printf("%d ", array[i]);
    }
    printf("\n");

    return 0;
}
