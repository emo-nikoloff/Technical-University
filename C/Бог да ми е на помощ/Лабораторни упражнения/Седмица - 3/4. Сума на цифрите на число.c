/*Събираме цифрите на четирицифрено число, след което разменяме мястото на първата и последната цифра.*/
#include <stdio.h>

int main(void)
{
    int number;
    printf("Enter a number: ");
    scanf("%d", &number);

    int fourthDigit = number % 10;
    int lessNumber = number / 10;
    int thirdDigit = lessNumber % 10;
    int lesserNumber = lessNumber / 10;
    int secondDigit = lesserNumber % 10;
    int leastNumber = lesserNumber / 10;
    int firstDigit = leastNumber % 10;
    int sum = firstDigit + secondDigit + thirdDigit + fourthDigit;


    printf("Sum of the digits of the number: %d\n", sum);
    printf("The number with reversed first and last digit: %d%d%d%d", fourthDigit, secondDigit, thirdDigit, firstDigit);

    return 0;
}
