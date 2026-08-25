/*Динамичен масив с цели числа. Заделете нов масив динамично и в новия масив копирайте елементите с положителни стойности кратни на 5. Принтирайте новия масив*/
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

    int count = 0;
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Enter an element: ");
        scanf("%d", &array[i]);
        if (array[i] % 5 == 0)
        {
            count++;
        }
    }

    for (int i = 0; i < magicNumber; i++)
    {
        printf("%d\n", array[i]);
    }

    printf("\n%d\n", count);

    int *anotherArray = calloc(count, sizeof(int));

    if (anotherArray == NULL)
    {
        exit(1);
    }

    int index = 0;
    for (int i = 0; i < magicNumber; i++)
    {
        if (array[i] > 0 && array[i] % 5 == 0)
        {
            anotherArray[index] = array[i];
            index++;
        }
    }

    printf("\n");
    for (int i = 0; i < count; i++)
    {
        printf("%d\n", anotherArray[i]);
    }

    free(array);
    free(anotherArray);

    return 0;
}
