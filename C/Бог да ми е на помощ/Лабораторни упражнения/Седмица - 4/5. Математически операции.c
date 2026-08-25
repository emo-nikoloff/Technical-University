/*Четат се 2 цели числа, след което се въвежда вида на математическата операцията и се извежда резултата.*/
#include <stdio.h>

int main(void)
{
    int firstNumber, secondNumber;
    printf("Enter the first number: ");
    scanf("%d", &firstNumber);
    printf("Enter the second number: ");
    scanf("%d", &secondNumber);
    getchar();
    char symbol;
    printf("Enter the operator: ");
    scanf("%c", &symbol);

    switch (symbol)
    {
        case '+':
            printf("%d %c %d = %d", firstNumber, symbol, secondNumber, (firstNumber + secondNumber));
            break;
        case '-':
            printf("%d %c %d = %d", firstNumber, symbol, secondNumber, (firstNumber - secondNumber));
            break;
        case '*':
            printf("%d %c %d = %d", firstNumber, symbol, secondNumber, (firstNumber * secondNumber));
            break;
        case '/':
            printf("%d %c %d = %.2lf", firstNumber, symbol, secondNumber, ((double) firstNumber / secondNumber));
            break;
        default:
            printf("Enter a valid operator!!!");
    }

    return 0;
}
