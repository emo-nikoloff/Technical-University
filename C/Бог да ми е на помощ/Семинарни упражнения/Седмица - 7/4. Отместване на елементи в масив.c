/*Напишете програма, която получава редица с цели N числа. След това получава цяло число K. Отместете всички елементи на редицата с K позиции, като използвате правилото за
превъртане (когато елемент от последна позиция трябва да се измести, то той трябва да отиде на първа позиция в редицата).*/
#include <stdio.h>

int main(void)
{
    int magicNumber, magicPositioner;
    printf("Enter the magic number: ");
    scanf("%d", &magicNumber);
    printf("Enter the magic positioner: ");
    scanf("%d", &magicPositioner);

    int array[magicNumber];
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Enter element: ");
        scanf("%d", &array[i]);
    }

    printf("The array:\n");
    for (int i = 0; i < magicNumber; i++)
    {
        printf("array[%d] = %d\n", i, array[i]);
    }

    int newArray[magicNumber];
    for (int i = 0; i < magicNumber; i++)
    {
        newArray[(i + magicPositioner) % magicNumber] = array[i];
    }

    printf("\nThe array after moving each element with %d positions:\n", magicPositioner);
    for (int i = 0; i < magicNumber; i++)
    {
        printf("array[%d] = %d\n", i, newArray[i]);
    }

    return 0;
}
