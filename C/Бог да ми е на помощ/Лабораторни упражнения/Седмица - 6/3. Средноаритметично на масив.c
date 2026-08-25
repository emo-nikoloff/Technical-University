/*Дефинираме фнкция, която приема като аргумент целочислен масив и брой елементи на масива. Връща като резултат средноаритметичната стойност
от тези елементи на масива, които са положителни. В главната функция main() се дефинира масив в интервал [-5000; 5000],
след което викаме функцията и принтираме резултата. Принтираме също елементите, които са със стойност по-голяма от средноаритметичното.*/
#include <stdio.h>

double arrayFunc(int myArray[], int size);

int main(void)
{
    int magicNumber;
    printf("Enter the number of elements in the array: ");
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

    double average = arrayFunc(array, magicNumber);
    printf("\nThe average of the positive numbers in the array: %.2lf\n\n", average);

    printf("The elements which value is bigger than the average:\n");
    for (int i = 0; i < magicNumber; i++)
    {
        if (array[i] > average)
        {
            printf("array[%d] = %d\n", i, array[i]);
        }
    }

    return 0;
}

double arrayFunc(int myArray[], int size)
{
    int sum = 0;
    int counter = 0;
    for (int i = 0; i < size; i++)
    {
        if (myArray[i] > 0)
        {
            sum += myArray[i];
            counter++;
        }
    }
    double average = (double) sum / counter;
    return average;
}
