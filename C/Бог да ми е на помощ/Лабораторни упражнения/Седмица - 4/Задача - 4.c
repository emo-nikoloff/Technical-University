/*Четем число между 1-7 и принтираме деня от седмицата.*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter a number: ");
    scanf("%d", &magicNumber);

    switch (magicNumber)
    {
        case 1:
            printf("Today is Monday");
            break;
        case 2:
            printf("Today is Tuesday");
            break;
        case 3:
            printf("Today is Wednesday");
            break;
        case 4:
            printf("Today is Thursday");
            break;
        case 5:
            printf("Today is Friday");
            break;
        case 6:
            printf("Today is Saturday");
            break;
        case 7:
            printf("Today is Sunday");
            break;
        default:
            printf("Enter a valid number!!!");
            break;
    }
    return 0;
}
