/*Стена с дължина L метра трябва да бъде боядисана. Един бояджия боядисва по x метра на ден. Напишете програма, която да намира колко дни са необходими, за да бъде боядисана стената.*/
#include <stdio.h>

int main(void)
{
    int L;
    printf("Meters to be painted: ");
    scanf("%d", &L);

    int painted = 0;
    int days = 0;
    while (painted < L)
    {
        int x;
        printf("Meters to be painted for the day: ");
        scanf("%d", &x);

        painted += x;
        days++;
    }
    printf("The worker painted the whole wall.\nHe needed %d days to paint the wall.", days);

    return 0;
}
