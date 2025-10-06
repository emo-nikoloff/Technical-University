/*Да се напише програма, която проверява дали между елементите на редицата a0, a1, ..., an са изпълнени релациите: a0 < a1 > a2 < a3 ...
(въвеждат се N и елементите на редицата)*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter number of elements: ");
    scanf("%d", &magicNumber);

    int array[magicNumber] = {};
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

    int isValid = 1;
    for (int i = 0; i < magicNumber - 1; i++)
    {
        if (i % 2 == 0)
        {
            if (array[i] > array[i + 1])
            {
                isValid = 0;
                break;
            }
        }
        else
        {
            if (array[i] < array[i + 1])
            {
                isValid = 0;
                break;
            }
        }
    }

    if (isValid)
    {
        printf("The sequence follows the pattern: a0 < a1 > a2 < a3 ...\n");
    }
    else
    {
        printf("The sequence does NOT follow the pattern.\n");
    }

    return 0;
}
