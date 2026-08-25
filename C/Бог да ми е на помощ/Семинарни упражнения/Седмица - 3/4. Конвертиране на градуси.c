/*Напишете конвертор от градуси в радиани.*/
#include <stdio.h>

int main()
{
    double degrees;
    printf("Enter degrees: ");
    scanf("%lf", &degrees);

    double degreesToRadians = degrees * 0.017453;
    printf("Radians: %lf", degreesToRadians);

    return 0;
}
