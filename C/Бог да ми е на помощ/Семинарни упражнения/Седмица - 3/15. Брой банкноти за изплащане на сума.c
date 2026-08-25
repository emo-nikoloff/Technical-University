/*Дадена е сума пари s. Напишете програма, която да намира минималния брой монети с номинал 1, 2, 5 и 10 лева, които са необходими, за да се плати тази сума*/
#include <stdio.h>

int main(void)
{
    int s;
    printf("Enter sum: ");
    scanf("%d", &s);

    int oneLevCount = 0, twoLevaCount = 0, fiveLevaCount = 0, tenLevaCount = 0;
    while (s > 0)
    {
        if (s >= 10)
        {
            s -= 10;
            tenLevaCount++;
        }
        if (s >= 5)
        {
            s -= 5;
            fiveLevaCount++;
        }
        if (s >= 2)
        {
            s -= 2;
            twoLevaCount++;
        }
        if (s >= 1)
        {
            s -= 1;
            oneLevCount++;
        }
    }
    printf("The needed money to reach %d leva are: %d*1, %d*2, %d*5, %d*10\n", s, oneLevCount, twoLevaCount, fiveLevaCount, tenLevaCount);

    return 0;
}
