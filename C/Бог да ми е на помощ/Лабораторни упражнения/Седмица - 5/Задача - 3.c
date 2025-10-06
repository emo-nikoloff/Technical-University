/*Програма, в която се въвежда цяло число, което представлява код на фигура: 1-квадрат, 2-правоъгълник, 3-правоъгълен триъгълник.
След това се въвеждат размерите на желаната фигура. Изведете типа фигура и лицето ѝ. За пресмятането на лицето напишете подходящи функции.*/
#include <stdio.h>

double square(double side);

double rectangle(double sideA, double sideB);

double rectangularTriangle(double sideA, double sideB);

int main(void)
{
    int magicNumber;
    while (magicNumber > 3 || magicNumber < 1)
    {
        printf("Choose a number between 1-3: ");
        scanf("%d", &magicNumber);
        if (magicNumber >= 1 && magicNumber <= 3)
        {
            if (magicNumber == 1)
            {
                printf("The chosen figure is square.\n");

                double a;
                printf("Enter value for a: ");
                scanf("%lf", &a);

                double area = square(a);
                printf("The area of the square is: %.2lf", area);
            }
            else if (magicNumber == 2)
            {
                printf("The chosen figure is rectangle.\n");

                double a, b;
                printf("Enter value for a: ");
                scanf("%lf", &a);
                printf("Enter value for b: ");
                scanf("%lf", &b);

                double area = rectangle(a, b);
                printf("The area of the rectangle is: %.2lf", area);
            }
            else if (magicNumber == 3)
            {
                printf("The chosen figure is rectangular triangle.\n");

                double a, b;
                printf("Enter value for a: ");
                scanf("%lf", &a);
                printf("Enter value for b: ");
                scanf("%lf", &b);

                double area = rectangularTriangle(a, b);
                printf("The area of the rectangular triangle is: %.2lf", area);
            }
        }
        else
        {
            printf("Wrong input!!!\n\n");
        }
    }
}

double square(double side)
{
    return side * side;
}

double rectangle(double sideA, double sideB)
{
    return sideA * sideB;
}

double rectangularTriangle(double sideA, double sideB)
{
    return (sideA * sideB) / 2;
}
