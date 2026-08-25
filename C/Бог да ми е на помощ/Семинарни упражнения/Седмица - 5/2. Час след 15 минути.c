/*Да се напише програма, която чете час и минути от 24-часово денонощие, въведени от потребителя, и изчислява колко ще е часът след 15 минути. Резултатът да се отпечата
във формат hh:mm. Часовете винаги са между 0 и 23, а минутите винаги са между 0 и 59. Часовете се изписват с една или две цифри. Минутите се изписват винаги с по две цифри,
с водеща нула когато е необходимо.*/
#include <stdio.h>

int main(void)
{
    int hours, minutes;
    printf("Enter hours: ");
    scanf("%d", &hours);
    printf("Enter minutes: ");
    scanf("%d", &minutes);

    int newTime = minutes + 15;
    if (newTime > 59)
    {
        hours++;
        newTime -= 60;
    }
    if (hours > 23)
    {
        hours = 0;
    }

    if (newTime < 10)
    {
        printf("The time is: %d:0%d ", hours, newTime);
    }
    else
    {
        printf("The time is: %d:%d ", hours, newTime);
    }

    return 0;
}
