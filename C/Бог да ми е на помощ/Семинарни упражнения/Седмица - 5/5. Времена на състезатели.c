/*Трима спортни състезатели финишират за някакъв брой секунди (между 1 и 50). Да се напише програма, която чете времената на състезателите, въведени от потребителя, и пресмята сумарното им
време във формат "минути:секунди". Секундите да се изведат с водеща нула (2: "02", 7: "07", 35: "35").*/
#include <stdio.h>

int main(void)
{
    int firstContestantTime, secondContestantTime, thirdContestantTime;
    printf("Enter the first contestant's time: ");
    scanf("%d", &firstContestantTime);
    printf("Enter the second contestant's time: ");
    scanf("%d", &secondContestantTime);
    printf("Enter the third contestant's time: ");
    scanf("%d", &thirdContestantTime);

    if (firstContestantTime > 50 || secondContestantTime > 50 || thirdContestantTime > 50)
    {
        printf("Invalid input!!\nThe time must be 1 - 50 seconds.");
    }
    else
    {
        int sumContestantsTime = 0, minutes = 0;
        for (int i = 1; i <= 3; i++)
        {
            if (i == 1)
            {
                sumContestantsTime += firstContestantTime;
            }
            else if (i == 2)
            {
                sumContestantsTime += secondContestantTime;
            }
            else if (i == 3)
            {
                sumContestantsTime += thirdContestantTime;
            }

            if (sumContestantsTime > 59)
            {
                minutes++;
                sumContestantsTime -= 60;
            }
        }
        if (sumContestantsTime < 10)
        {
            printf("%d:0%d", minutes, sumContestantsTime);
        }
        else
        {
            printf("%d:%d", minutes, sumContestantsTime);
        }
    }

    return 0;
}
