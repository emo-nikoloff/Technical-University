/*Четем 2 целочислени променливи, четем стойности за тези променливи, принтираме ги, след това им разменяме стойностите.*/
#include <stdio.h>

int main(void)
{
    int a;
    int b;
    printf("Enter digit: ");
    scanf("%d", &a);
    printf("Enter digit: ");
    scanf("%d", &b);

    printf("Digit 1: %d\nDigit 2: %d", a, b);

    a = a + b;
    b = a - b;
    a = a - b;
    printf("\nReversed:\nDigit 1: %d\nDigit 2: %d", a, b);

    return 0;
}
