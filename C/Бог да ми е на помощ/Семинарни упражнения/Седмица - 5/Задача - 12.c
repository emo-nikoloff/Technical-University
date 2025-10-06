/*Да се напише програма, която прочита от конзолата цяло число n, въведено от потребителя, и чертае пеперуда с ширина 2 * n - 1 колони и височина 2 * (n - 2) + 1 реда.
Лявата и дясната ѝ част са широки n - 1.*/
#include <stdio.h>

int main(void)
{
    int magicNumber;
    printf("Enter the magic number: ");
    scanf("%d", &magicNumber);

    if (magicNumber < 3)
    {
        printf("The butterfly isn't born yet!");
    }
    else
    {
        for (int firstPart = 1; firstPart <= magicNumber - 2; firstPart++)
        {
            if (firstPart % 2 != 0)
            {
                for (int leftSide = 0; leftSide < magicNumber - 2; leftSide++)
                {
                    printf("*");
                }
                printf("\\ /");
                for (int rightSide = 0; rightSide < magicNumber - 2; rightSide++)
                {
                    printf("*");
                }
                printf("\n");
            }
            else if (firstPart % 2 == 0)
            {
                for (int leftSide = 0; leftSide < magicNumber - 2; leftSide++)
                {
                    printf("-");
                }
                printf("\\ /");
                for (int rightSide = 0; rightSide < magicNumber - 2; rightSide++)
                {
                    printf("-");
                }
                printf("\n");
            }
        }

        for (int intervals = 0; intervals < magicNumber - 1; intervals++)
        {
            printf(" ");
        }
        printf("@\n");

        for (int secondPart = 1; secondPart <= magicNumber - 2; secondPart++)
        {
            if (secondPart % 2 != 0)
            {
                for (int leftSide = 0; leftSide < magicNumber - 2; leftSide++)
                {
                    printf("*");
                }
                printf("/ \\");
                for (int rightSide = 0; rightSide < magicNumber - 2; rightSide++)
                {
                    printf("*");
                }
                printf("\n");
            }
            else if (secondPart % 2 == 0)
            {
                for (int leftSide = 0; leftSide < magicNumber - 2; leftSide++)
                {
                    printf("-");
                }
                printf("/ \\");
                for (int rightSide = 0; rightSide < magicNumber - 2; rightSide++)
                {
                    printf("-");
                }
                printf("\n");
            }
        }
    }

    return 0;
}
