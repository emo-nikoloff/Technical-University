/*Напишете програма, която чете градуси по скалата на Целзий и ги превръща в градуси по Фаренхайт.*/
#include <stdio.h>

int main()
{
    double celsius;
    printf("Enter the temperature in Celsius: ");
    scanf("%lf", &celsius);

    double fahrenheit = celsius * 33.8;
    printf("Temperature in Fahrenheint: %.2lf", fahrenheit);

    return 0;
}
