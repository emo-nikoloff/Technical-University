/*На площадката пред жилищен блок трябва да се поставят плочки. Площадката е с форма на квадрат със страна N метра. Плочките са широки W метра и дълги L метра.
На площадката има една пейка с ширина M метра и дължина O метра. Под нея не е нужно да се слагат плочки. Всяка плочка се поставя за 0.2 минути. Напишете програма, която чете от конзолата
размерите на площадката, плочките и пейката и пресмята колко плочки са необходими да се покрие площадката и пресмята времето за поставяне на всички плочки.*/
#include <stdio.h>

int main(void)
{
    double N;
    printf("Enter playground side: ");
    scanf("%lf", &N);

    double W;
    printf("Enter tile's width: ");
    scanf("%lf", &W);
    double L;
    printf("Enter tile's length: ");
    scanf("%lf", &L);

    double M;
    printf("Enter bench's width: ");
    scanf("%lf", &M);
    double O;
    printf("Enter bench's length: ");
    scanf("%lf", &O);

    double playground = N * N;
    double tile = W * L;
    double bench = M * O;
    double playgroundWithTiles = (playground - bench) / tile;
    double neededTime = playgroundWithTiles * 0.2;
    printf("The playground with placed tile: %.2lf\nNeeded time for placing the tiles: %.2lf minutes", playgroundWithTiles, neededTime);

    return 0;
}
