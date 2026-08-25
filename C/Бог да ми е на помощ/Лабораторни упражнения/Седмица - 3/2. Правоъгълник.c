/*По въведени страни от потребителя намерете лице и обиколка на правоъгълник.*/
#include <stdio.h>

int main(void)
{
    double sideA;
    double sideB;
    printf("Enter side of the rectangular:\t ");
    scanf("%lf", &sideA);
    printf("Enter side of the rectangular:\t ");
    scanf("%lf", &sideB);

    double perimeter = 2 * sideA + 2 * sideB;
    double area = sideA * sideB;
    printf("The perimeter of the rectangular is: %.2lf\nThe area of the rectangular is: %.2lf", perimeter, area);

    return 0;
}
