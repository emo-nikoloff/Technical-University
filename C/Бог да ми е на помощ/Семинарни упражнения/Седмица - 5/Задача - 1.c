/*Напишете програма,в която се въвеждат две числа и се извежда по – голямото от тях.*/
#include <stdio.h>

int main(void)
{
    int firstNumber, secondNumber;
    printf("Enter the first number: ");
    scanf("%d", &firstNumber);
    printf("Enter the second number: ");
    scanf("%d", &secondNumber);

    if (firstNumber < secondNumber)
    {
        printf("%d is the bigger number", secondNumber);
    }
    else if (firstNumber > secondNumber)
    {
        printf("%d is the bigger number", firstNumber);
    }
    else
    {
        printf("The numbers are equal!");
    }

    return 0;
}
