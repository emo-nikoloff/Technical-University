/*Четем 2 цели и извеждаме сумата между тези 2 числа(не са включени в сумата), като не е задължително двете числа да са от по-малко към по-голямо.*/
#include <stdio.h>

int main(void)
{
    int firstNumber, secondNumber;
    printf("Enter the first number: ");
    scanf("%d", &firstNumber);
    printf("Enter the second number: ");
    scanf("%d", &secondNumber);

    int sum = 0;
    if (firstNumber > secondNumber)
    {
        for (int i = secondNumber + 1; i < firstNumber; i++)
        {
            sum += i;
        }
        printf("%d", sum);
    }
    else if (firstNumber < secondNumber)
    {
        for (int i = firstNumber + 1; i < secondNumber; i++)
        {
            sum += i;
        }
        printf("%d", sum);
    }

    return 0;
}
