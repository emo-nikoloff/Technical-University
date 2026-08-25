/*От лозе с площ Х кв.м се заделя 40% от реколтата за производството на вино. От 1 кв.м лозе се изкарват Y кг грозде. За 1 литър вино са нужни 2,5 кг грозде. Желаното количество вино за продан е
Z литра. Напишете програма, която пресмята колко вино може да се произведе и дали това количество е достатъчно. Ако е достатъчно, остатъкът се разделя по равно между работниците на лозето.*/
#include <math.h>
#include <stdio.h>

int main(void)
{
    int vineyardArea, grapeKG, wineToSell;
    printf("Enter the vineyard's area: ");
    scanf("%d", &vineyardArea);
    printf("Enter the picked grapes's KGs: ");
    scanf("%d", &grapeKG);
    printf("Enter the wine L to sell: ");
    scanf("%d", &wineToSell);

    double grapes = vineyardArea * grapeKG;
    double grapesForProducing = grapes * 0.4;
    double wineProduced = 2.5 * grapesForProducing;

    printf("The produced wine is %.2lf L", wineProduced);
    if (wineProduced > wineToSell)
    {
        double leftOver = wineProduced - wineToSell;
        printf("The rest of the wine is %.2lf\nDivide the rest of the wine between the workers", leftOver);
    }
    else
    {
        double needed = abs(wineProduced - wineToSell);
        printf("The produced wine is not enough!\nYou need to produce %lfL more", needed);
    }

    return 0;
}
