/*Дефинираме целочислен масив с n-брой елемента, като n се въвежда от потребителя. Запълваме масива с числа [-5000; 5000] въведени от потребителя.
След което намираме най-малкото нечетно число.*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter the number of elements in the array:");
    scanf("%d", &magicNumber);
    int array[magicNumber] = {};
    int checker = 0;
    while (checker < magicNumber)
    {
        printf("Enter element: ");
        scanf("%d", &array[checker]);
        if (array[checker] < -5000 || array[checker] > 5000)
        {
            printf("May the values be in the range!\n");
        }
        else
        {
            checker++;
        }
    }
    printf("The array:\n");
    for (int i = 0; i < magicNumber; i++)
    {
        printf("array[%d] = %d\n", i, array[i]);
    }
    int min = 5001;
    for (int i = 0; i < magicNumber; i++)
    {
        if (array[i] % 2 != 0 && array[i] < min)
        {
            min = array[i];
        }
    }
    printf("The smallest odd number in the array is: %d\n", min);

    return 0;
}
