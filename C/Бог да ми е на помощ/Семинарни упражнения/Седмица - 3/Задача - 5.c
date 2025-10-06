/*Напишете конвертор от левове в долари, евро в паундове.*/
#include <stdio.h>

int main()
{
    double levs;
    printf("Enter levs: ");
    scanf("%lf", &levs);

    double euro;
    printf("Enter euro: ");
    scanf("%lf", &euro);

    double levsToDollars = levs * 0.53;
    double euroToPounds = euro * 0.83;
    printf("Levs to dollars: %.2lf\nEuro to pounds: %.2lf", levsToDollars, euroToPounds);

    return 0;
}
