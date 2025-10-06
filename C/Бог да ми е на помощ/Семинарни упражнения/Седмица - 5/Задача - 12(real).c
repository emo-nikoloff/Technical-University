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
        for (int rows = 1; rows <= 2 * (magicNumber - 2) + 1; rows++)
        {
            if (rows == magicNumber - 1)
            {
                for (int intervals = 1; intervals <= magicNumber - 1; intervals++)
                {
                    printf(" ");
                }
                printf("@\n");
            }
            else
            {
                if (rows < magicNumber)
                {
                    if (rows % 2 != 0)
                    {
                        for (int leftSide = 1; leftSide <= magicNumber - 1; leftSide++)
                        {
                            if (leftSide < magicNumber - 1)
                            {
                                printf("*");
                            }
                            else
                            {
                                printf("\\");
                            }
                        }
                        printf(" ");
                        for (int rightSide = 1; rightSide <= magicNumber - 1; rightSide++)
                        {
                            if (rightSide == 1)
                            {
                                printf("/");
                            }
                            else
                            {
                                printf("*");
                            }
                        }
                        printf("\n");
                    }
                    else if (rows % 2 == 0)
                    {
                        for (int leftSide = 1; leftSide <= magicNumber - 1; leftSide++)
                        {
                            if (leftSide < magicNumber - 1)
                            {
                                printf("-");
                            }
                            else
                            {
                                printf("\\");
                            }
                        }
                        printf(" ");
                        for (int rightSide = 1; rightSide <= magicNumber - 1; rightSide++)
                        {
                            if (rightSide == 1)
                            {
                                printf("/");
                            }
                            else
                            {
                                printf("-");
                            }
                        }
                        printf("\n");
                    }
                }
                else
                {
                    if (rows % 2 != 0)
                    {
                        for (int leftSide = 1; leftSide <= magicNumber - 1; leftSide++)
                        {
                            if (leftSide < magicNumber - 1)
                            {
                                printf("*");
                            }
                            else
                            {
                                printf("/");
                            }
                        }
                        printf(" ");
                        for (int rightSide = 1; rightSide <= magicNumber - 1; rightSide++)
                        {
                            if (rightSide == 1)
                            {
                                printf("\\");
                            }
                            else
                            {
                                printf("*");
                            }
                        }
                        printf("\n");
                    }
                    else if (rows % 2 == 0)
                    {
                        for (int leftSide = 1; leftSide <= magicNumber - 1; leftSide++)
                        {
                            if (leftSide < magicNumber - 1)
                            {
                                printf("-");
                            }
                            else
                            {
                                printf("/");
                            }
                        }
                        printf(" ");
                        for (int rightSide = 1; rightSide <= magicNumber - 1; rightSide++)
                        {
                            if (rightSide == 1)
                            {
                                printf("\\");
                            }
                            else
                            {
                                printf("-");
                            }
                        }
                        printf("\n");
                    }
                }
            }
        }
    }

    return 0;
}
