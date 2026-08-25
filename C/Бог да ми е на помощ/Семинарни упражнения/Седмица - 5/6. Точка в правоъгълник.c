/*Напишете програма, която проверява дали точка {x, y} се намира вътре в правоъгълник {x1, y1} – {x2, y2}. Входните данни се четат от конзолата и се състоят от 6 реда:
-> десетичните числа x, y, x1, y1, x2, y2 (като се гарантира, че x1 < x2 и y1 < y2) Една точка е вътрешна за даден правоъгълник, ако се намира някъде във вътрешността му или върху някоя
от страните му. Отпечатайте "Inside" или "Outside".*/
#include <stdio.h>

int main(void)
{
    int x, y;
    printf("X coordinates for the point: ");
    scanf("%d", &x);
    printf("Y coordinates for the point: ");
    scanf("%d", &y);

    int x1, x2, y1, y2;
    printf("X1 coordinates for the rectangular: ");
    scanf("%d", &x1);
    printf("Y1 coordinates for the rectangular: ");
    scanf("%d", &y1);
    printf("X2 coordinates for the rectangular: ");
    scanf("%d", &x2);
    printf("Y2 coordinates for the rectangular: ");
    scanf("%d", &y2);
    if (x1 < x2 && y1 < y2)
    {
        if ((x <= x2 && x >= x1) && (y <= y2 && y >= y1))
        {
            printf("Inside");
        }
        else
        {
            printf("Outside");
        }
    }
    else
    {
        printf("Rectangular can't be made!");
    }

    return 0;
}
