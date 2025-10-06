/*Напишете програма, която конвертира от въведени от потребителя инчове в милиметри, сантиметри, дециметри и метри. Напишете подходящ интерфейс за общуване с потребителя.*/
#include <stdio.h>

int main()
{
    double inches;
    printf("Enter inches: ");
    scanf("%lf", &inches);

    double inchesToMillimeters = inches * 25.4;
    double inchesToCentimeters = inches * 2.54;
    double inchesToDecimeters = inches * 0.254;
    double inchesToMeters = inches * 0.0254;

    printf("Inches to millimeters: %.2lf\nInches to centimeters: %.2lf\nInches to decimeters: %.2lf\nInches to meters %.2lf",
           inchesToMillimeters, inchesToCentimeters, inchesToDecimeters, inchesToMeters);

    return 0;
}
