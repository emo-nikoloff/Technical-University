/*По въведени параметри за лице на трапец пресметнете лицето му.*/
#include <stdio.h>

int main()
{
    double a;
    printf("Enter side a: ");
    scanf("%lf", &a);
    double b;
    printf("Enter side b: ");
    scanf("%lf", &b);
    double h;
    printf("Enter height: ");
    scanf("%lf", &h);

    double sum = ((a + b) / 2) * h;
    printf("The area ot the trapezoid is: %.2lf", sum);

    return 0;
}
