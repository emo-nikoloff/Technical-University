/*Напишете програма, която получава масив от N елемента и обръща реда на елементите. Изкарайте новополучения масив.*/
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

    printf("The array:\n");
    for (int i = 0; i < magicNumber; i++)
    {
        printf("array[%d]: %d\n", i, array[i]);
    }

    int newArray[magicNumber] = {};
    for (int i = 0; i < magicNumber; i++)
    {
        newArray[i] = array[(magicNumber - 1) - i];
    }

    printf("\nThe array with reversed elements:\n");
    for (int i = 0; i < magicNumber; i++)
    {
        printf("array[%d]: %d\n", i, newArray[i]);
    }

    return 0;
}
