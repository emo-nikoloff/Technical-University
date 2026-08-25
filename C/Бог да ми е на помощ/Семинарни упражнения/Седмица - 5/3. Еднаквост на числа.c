/*Да се напише програма, която чете 3 числа и отпечатва дали са еднакви (yes/no).*/
#include <stdio.h>

int main(void)
{
    int firstNumber, secondNumber, thirdNumber;
    printf("Enter the first number: ");
    scanf("%d", &firstNumber);
    printf("Enter the second number: ");
    scanf("%d", &secondNumber);
    printf("Enter the third number: ");
    scanf("%d", &thirdNumber);

    if (firstNumber == secondNumber && secondNumber == thirdNumber && firstNumber == thirdNumber)
    {
        printf("YES!!\n");
    }
    else
    {
        printf("NO!!\n");
    }

    return 0;
}
