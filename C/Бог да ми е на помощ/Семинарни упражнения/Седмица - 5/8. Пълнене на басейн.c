/*Басейн с обем V(кубични метра) има две тръби, от които се пълни. Всяка тръба има определен дебит(литрите вода, минаващи през една тръба за един час). Работникът пуска тръбите
едновременно и излиза за N часа. Напишете програма, която изкарва състоянието на басейна в момента, когато работникът се върне.*/
#include <stdio.h>

int main(void)
{
    int firstPipeCapacity, secondPipeCapacity, hoursToComplete;
    printf("Enter the capacity of the first pipe: ");
    scanf("%d", &firstPipeCapacity);
    printf("Enter the capacity of the second pipe: ");
    scanf("%d", &secondPipeCapacity);
    printf("Enter the pipe's working hours: ");
    scanf("%d", &hoursToComplete);

    int firstPipeProducedWater = 0, secondPipeProducedWater = 0;
    for (int hoursOperating = 0; hoursOperating < hoursToComplete; hoursOperating++)
    {
        if (firstPipeProducedWater < firstPipeCapacity)
        {
            firstPipeProducedWater++;
        }
        if (secondPipeProducedWater < secondPipeCapacity)
        {
            secondPipeProducedWater++;
        }
    }

    printf("The pool was filled with %dL water for %d hours", firstPipeProducedWater + secondPipeProducedWater, hoursToComplete);

    return 0;
}
