/*По дадени координати на три точки, нележащи на една права, намерете лицето на триъгълника, формиран от тях.*/
#include <stdio.h>
#include <math.h>

int main()
{
    double Ax;
    printf("Enter A(x): ");
    scanf("%lf", &Ax);
    double Ay;
    printf("Enter A(y): ");
    scanf("%lf", &Ay);
    double Bx;
    printf("Enter B(x): ");
    scanf("%lf", &Bx);
    double By;
    printf("Enter B(y): ");
    scanf("%lf", &By);
    double Cx;
    printf("Enter C(x): ");
    scanf("%lf", &Cx);
    double Cy;
    printf("Enter C(y): ");
    scanf("%lf", &Cy);

    double c = fabs(Bx) - fabs(Ax);
    double hc = fabs(Cy) - fabs(By);
    double sum = (c * hc) / 2;
    printf("The area of the triangle is: %.2lf", sum);

    return 0;
}
