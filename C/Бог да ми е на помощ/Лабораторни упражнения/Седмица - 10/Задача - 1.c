/*Дефинирайте структура по избор, след което дефинирате променлива от тип тази структура, след което четете стойности за полетата и принтирате информацията. Да се дефинира масив от структурата
и да се изведе едно от полетата по избор на всичките елементи в масива в обратен ред.*/
#include <stdio.h>

struct Car
{
    char brand[30];
    char model[30];
    int year;
};

struct Driver
{
    struct Car car;
    char firstName[30];
    char lastName[30];
    int age;
};

int main()
{
    struct Driver owner;

    printf("Choose car's brand: ");
    scanf("%s", owner.car.brand);

    printf("Choose car's model: ");
    scanf("%s", owner.car.model);

    printf("Choose car's year: ");
    scanf("%d", &owner.car.year);

    printf("Owner's first name: ");
    scanf(" %s", owner.firstName);

    printf("Owner's last name: ");
    scanf("%s", owner.lastName);

    printf("Owner's age: ");
    scanf("%d", &owner.age);

    printf("The car is: %s %s - %d\n", owner.car.brand, owner.car.model, owner.car.year);
    printf("The owner is: %s %s - %d years old\n", owner.firstName, owner.lastName, owner.age);

    int magicNumber;
    printf("\nHow many cars does the shop have: ");
    scanf("%d", &magicNumber);

    struct Car shopList[magicNumber];
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Choose car's brand: ");
        scanf("%s", shopList[i].brand);

        printf("Choose car's model: ");
        scanf("%s", shopList[i].model);

        printf("Choose car's year: ");
        scanf("%d", &shopList[i].year);
    }

    printf("Available cars:\n");
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Car's brand: %s\n", shopList[i].brand);
        printf("Car's model: %s\n", shopList[i].model);
        printf("Car's year: %d\n", shopList[i].year);
    }

    printf("\nThe car's years reversed:\n");
    for (int i = 0; i < magicNumber; i++)
    {
        printf("Car's brand: %s\n", shopList[i].brand);
        printf("Car's model: %s\n", shopList[i].model);
        for (int j = magicNumber - 1 - i;;)
        {
            printf("Car's year: %d\n", shopList[j].year);
            break;
        }
    }

    return 0;
}
