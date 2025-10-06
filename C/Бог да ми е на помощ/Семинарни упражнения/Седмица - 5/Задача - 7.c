/*Студент трябва да пропътува n километра. Той има избор измежду три вида транспорт:
Такси - Начална такса: 0.70 лв; Дневна тарифа: 0.79 лв/км; Нощна тарифа: 0.90 лв/км.
Автобус - Дневна/нощна тарифа: 0.09 лв/км. Може да се използва за разстояния минимум 20 км.
Влак - Дневна/нощна тарифа: 0.06 лв/км. Може да се използва за разстояния минимум 100 км.
Напишете програма, която чете броя километри n и период от деня (ден-D или нощ-N), въведени от потребителя, и изчислява цената на най-евтиния транспорт.*/
#include <stdio.h>

int main(void)
{
    int kilometers;
    char partOfDay;
    printf("Enter the kilometers to travel: ");
    scanf("%d", &kilometers);
    printf("Enter the part of day: ");
    scanf(" %c", &partOfDay);

    if (kilometers <= 20)
    {
        double price = kilometers * 0.09;
        if (partOfDay == 'D')
        {
            printf("The cheapest way to travel %dkm during the day will be with autobus for %.2lf leva", kilometers, price);
        }
        else if (partOfDay == 'N')
        {
            printf("The cheapest way to travel %dkm during the night will be with autobus for %.2lf leva", kilometers, price);
        }
    }
    else if (kilometers <= 100)
    {
        double price = kilometers * 0.06;
        if (partOfDay == 'D')
        {
            printf("The cheapest way to travel %dkm during the day will be with train for %.2lf leva", kilometers, price);
        }
        else if (partOfDay == 'N')
        {
            printf("The cheapest way to travel %dkm during the night will be with train for %.2lf leva", kilometers, price);
        }
    }
    else
    {
        double price = 0;
        double startingPrice = 0.7;
        if (partOfDay == 'D')
        {
            price = startingPrice + (kilometers * 0.79);
        }
        else if (partOfDay == 'N')
        {
            price = startingPrice + (kilometers * 0.9);
        }

        if (partOfDay == 'D')
        {
            printf("The cheapest way to travel %dkm during the day will be with taxi for %.2lf leva", kilometers, price);
        }
        else if (partOfDay == 'N')
        {
            printf("The cheapest way to travel %dkm during the night will be with taxi for %.2lf leva", kilometers, price);
        }
    }

    return 0;
}
