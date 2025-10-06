/*Двор има правоъгълна форма с размери a на b метра. Собственикът иска да засади цветя в градина с форма на кръг, която да се намира изцяло във вътрешността на двора.
Намерете най-големия възможен радиус на кръглата градина.*/
#include <stdio.h>

int main(void)
{
    double a;
    printf("Enter backyard's side a: ");
    scanf("%lf", &a);
    double b;
    printf("Enter backyard's side b: ");
    scanf("%lf", &b);

    if (a > b)
    {
        double r = a / 2;
        printf("The biggest possible radius is %.2lf", r);
    }
    else if (a < b)
    {
        double r = b / 2;
        printf("The biggest possible radius is %.2lf", r);
    }

    return 0;
}
