/*Градинар продава реколтата от градината си на зеленчуковата борса. Продава зеленчуци за N лева на килограм и плодове за M лева за килограм. Напишете програма, която да пресмята
приходите от реколтата в евро (ако приемем, че едно евро е равно на 1.95 лв.). От конзолата се четат 4 числа, по едно на ред, въведени от потребителя.*/
#include <stdio.h>

int main(void)
{
    float vegetablesPrice;
    printf("Enter vegetables' price: ");
    scanf("%f", &vegetablesPrice);
    float fruitsPrice;
    printf("Enter fruits' price: ");
    scanf("%f", &fruitsPrice);
    int vegetablesKg;
    printf("Enter vegetables' kg: ");
    scanf("%d", &vegetablesKg);
    int fruitsKg;
    printf("Enter fruits' kg: ");
    scanf("%d", &fruitsKg);

    double profitInEuro = (vegetablesPrice * vegetablesKg + fruitsPrice * fruitsKg) * 1.95;
    printf("The profit in euro: %.2lf", profitInEuro);

    return 0;
}
