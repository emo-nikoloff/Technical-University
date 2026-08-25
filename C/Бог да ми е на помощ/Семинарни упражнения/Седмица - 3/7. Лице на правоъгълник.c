/*По дадени координати на два срещуположни ъгъла на правоъгълник чрез точки А и Б, намерете лицето на правоъгълника, който е ограничен от двете точки.*/
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

    double length = fabs(Bx) - fabs(Ax);
    double width = fabs(By) - fabs(Ay);
    double sum = length * width;
    printf("The area ot the rectangular is: %.2lf", sum);

    return 0;
}
