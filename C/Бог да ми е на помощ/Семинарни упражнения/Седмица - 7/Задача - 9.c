/*Напишете програма, която намира максималната редица от последователни еднакви елементи в масив и ги отпечатва.*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &magicNumber);

    int array[magicNumber] = {};
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Enter element: ");
        scanf("%d", &array[i]);
    }

    printf("[");
    for (int i = 0; i < magicNumber; i++)
    {
        if (i < magicNumber - 1)
        {
            printf("%d, ", array[i]);
        }
        else
        {
            printf("%d", array[i]);
        }
    }
    printf("]\n");

    int firstCounter = 0, secondCounter = 0;
    int firstArray[] = {}, biggestArray[] = {};
    int lengthOfFirstArray = sizeof(firstArray) / sizeof(firstArray[0]);
    for (int i = 0; i < magicNumber; i++)
    {
        if (array[i] == array[i + 1])
        {
            firstCounter++;
            if (firstCounter > secondCounter)
            {
                for (int j = 0; j < firstCounter; j++)
                {
                    biggestArray[j] = array[i];
                }
                break;
            }
            for (int j = 0; j < firstCounter; j++)
            {
                firstArray[j] = array[i];
            }
            secondCounter++;
        }
        else
        {
            firstCounter = 0;
        }
    }



    printf("[");
    for (int i = 0; i < sizeof(biggestArray) / sizeof(biggestArray[0]); i++)
    {
        if (i < (sizeof(biggestArray) / sizeof(biggestArray[0])) - 1)
        {
            printf("%d, ", biggestArray[i]);
        }
        else
        {
            printf("%d", biggestArray[i]);
        }
    }
    printf("]\n");

    return 0;
}
