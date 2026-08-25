/*Четем 2 цели числа(n и k), след това още на n-брой числа и се извежда броят на числата, които са по-големи от k и се делят на 3.*/
#include <stdio.h>

int main(void)
{
    int n, k;
    printf("Enter the end: ");
    scanf("%d", &n);
    printf("Enter the checker:");
    scanf("%d", &k);

    int counter = 0;
    for (int i = 1; i <= n; i++)
    {
        int number;
        printf("Enter a number: ");
        scanf("%d", &number);

        if (number > k && number % 3 == 0)
        {
            counter++;
        }
    }
    printf("The amount of numbers bigger than %d and are divided by 3 is: %d", k, counter);

    return 0;
}
