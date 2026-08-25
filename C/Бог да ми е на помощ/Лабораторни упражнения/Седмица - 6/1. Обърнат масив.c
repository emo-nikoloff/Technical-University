/*Дефинирайте целочислен масив със 7 елемента. Запълнете елемента със стойности въведени от потребителя,
след което принтирайте масива в обратен ред.*/
#include <stdio.h>

int main(void)
{
    int array[7] = {};
    for (int i = 0; i < 7; i++)
    {
        printf("Enter element: ");
        scanf("%d", &array[i]);
    }
    printf("The array reversed:\n");
    for (int i = 6; i > -1; i--)
    {
        printf("array[%d] = %d\n", i, array[i]);
    }

    return 0;
}
