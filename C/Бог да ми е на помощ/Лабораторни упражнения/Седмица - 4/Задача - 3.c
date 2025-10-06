/*Четем 3 цели числа и намираме най-малкото от тях.*/
#include <stdio.h>

int main(void)
{
    int firstNumber;
    printf("Enter the first number: ");
    scanf("%d", &firstNumber);
    int secondNumber;
    printf("Enter the second number: ");
    scanf("%d", &secondNumber);
    int thirdNumber;
    printf("Enter the third number: ");
    scanf("%d", &thirdNumber);

    if (firstNumber < secondNumber && firstNumber < thirdNumber)
    {
        printf("%d is the smallest number", firstNumber);
    }
    else if (secondNumber < firstNumber && secondNumber < thirdNumber)
    {
        printf("%d is the smallest number", secondNumber);
    }
    else if (thirdNumber < firstNumber && thirdNumber < secondNumber)
    {
        printf("%d is the smallest number", thirdNumber);
    }

    return 0;
}
