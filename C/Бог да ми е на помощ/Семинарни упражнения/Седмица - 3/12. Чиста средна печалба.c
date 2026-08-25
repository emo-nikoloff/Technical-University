/*Иван е програмист в американска компания и работи от вкъщи средно N дни в месеца, като изкарва средно по M долара на ден. В края на годината Иван получава бонус, който е равен на 2.5
месечни заплати. От спечеленото през годината му се удържат 25% данъци. Напишете програма, която да пресмята, колко е чистата средна печалба на Иван на ден в лева, тъй като той харчи
изкараното в България. Приема се, че в годината има точно 365 дни. Курсът на долара спрямо лева, ще се чете от конзолата.*/
#include <stdio.h>

int main(void)
{
    int N;
    printf("Enter working days: ");
    scanf("%d", &N);
    double M;
    printf("Enter dollars a day: ");
    scanf("%lf", &M);
    double dollarExchangeRate;
    printf("Enter dollar's exchange rate: ");
    scanf("%lf", &dollarExchangeRate);

    double bonus = (M * N) * 2.5;
    double annualSalary = (M * N) * 12 + bonus;
    double salaryAfterTaxes = annualSalary - annualSalary * 0.25;
    double earningsInLevs = ((salaryAfterTaxes) / 365) * dollarExchangeRate;
    printf("Earnings a day in levs: %.2lf\n", earningsInLevs);

    return 0;
}
