/*Дадени са n цели числа в интервала [1-1000]. От тях някакъв процент p1 са под 200, друг процент p2 са от 200 до 399, друг процент p3 са от 400 до 599, друг процент p4 са от 600 до 799 и
останалите p5 процента са от 800 нагоре. Да се напише програма, която изчислява и отпечатва процентите p1, p2, p3, p4 и p5.*/
#include <stdio.h>

int main(void)
{
    int limit;
    printf("How many numbers to enter: ");
    scanf("%d", &limit);

    int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0;
    for (int i = 1; i <= limit; i++)
    {
        int number;
        printf("Enter a number: ");
        scanf("%d", &number);

        if (number < 200)
        {
            p1++;
        }
        else if (number < 400)
        {
            p2++;
        }
        else if (number < 600)
        {
            p3++;
        }
        else if (number < 800)
        {
            p4++;
        }
        else
        {
            p5++;
        }
    }
    printf("Numbers under 200: %.2lf%%\n", ((double) p1 / limit) * 100);
    printf("Numbers under 400: %.2lf%%\n", ((double) p2 / limit) * 100);
    printf("Numbers under 600: %.2lf%%\n", ((double) p3 / limit) * 100);
    printf("Numbers under 800: %.2lf%%\n", ((double) p4 / limit) * 100);
    printf("Numbers over 800: %.2lf%%\n", ((double) p5 / limit) * 100);

    return 0;
}
