/*Правоъгълен басейн с размери x на y метра е заобиколен от пътека с ширина w метра. Намерете лицето на пътеката.*/
#include <stdio.h>
#include <math.h>

int main(void)
{
    double x, y, w;
    printf("Enter pool's width: ");
    scanf("%lf", &x);
    printf("Enter pool's length: ");
    scanf("%lf", &y);
    printf("Enter path's width: ");
    scanf("%lf", &w);

    double radius = (x / 2) + w;
    double area = 2 * M_PI * radius;
    printf("The area of the path is %.2lf\n", area);

    return 0;
}
