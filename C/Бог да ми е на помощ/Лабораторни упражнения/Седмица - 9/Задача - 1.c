/*Създайте динамичен масив с n-брой елементи, след което запълваме масива с цели числа. Намерете сумата на двуцифрените стойности и принтирайте сумата. Потребителят въвежда нов размер.
Ако новият размер е по-голям, въведете стойности в новите елементи.*/
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int magicNumber;
    printf("Enter a number: ");
    scanf("%d", &magicNumber);
    int *array = calloc(magicNumber, sizeof(int));

    if (array == NULL)
    {
        exit(1);
    }

    int sum = 0;
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Enter an element: ");
        scanf("%d", &array[i]);
        if (abs(array[i]) > 9 && abs(array[i]) < 100)
        {
            sum += array[i];
        }
    }

    for (int i = 0; i < magicNumber; i++)
    {
        printf("%d\n", array[i]);
    }
    printf("The sum of the double digit numbers is: %d\n", sum);

    int size;
    int *ptrArray = array;
    printf("\nEnter a number: ");
    scanf("%d", &size);
    array = (int *) realloc(ptrArray, size * sizeof(int));

    if (array == NULL)
    {
        exit(1);
    }

    if (size > magicNumber)
    {
        for (int i = magicNumber; i < size; i++)
        {
            printf("Enter an element: ");
            scanf("%d", &array[i]);
        }

        for (int i = 0; i < size; i++)
        {
            printf("%d\n", array[i]);
        }
    }
    else
    {
        for (int i = 0; i < size; i++)
        {
            printf("%d\n", array[i]);
        }
    }

    free(ptrArray);
    free(array);

    return 0;
}
