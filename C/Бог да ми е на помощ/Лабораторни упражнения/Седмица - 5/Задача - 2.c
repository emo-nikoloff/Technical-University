/*Функция, която разменя 2 числа. Приемат се 2 аргумента. Не се връща стойност.*/
#include <stdio.h>

void beautifulFunc(A, B)
{
    printf("The values of a and b:\n");
    printf("A = %d\n", A);
    printf("B = %d\n", B);
    int newA = B;
    int newB = A;
    printf("A and B reversed: %d <-> %d\n", newA, newB);
}

void uglyFunc(A, B)
{
    printf("The memory addresses of a and b:\n");
    printf("A = %p\n", A);
    printf("B = %p\n", B);
    int *newPointerA = &B;
    int *newPointerB = &A;
    printf("A and B reversed: %p <-> %p\n", newPointerA, newPointerB);
}

int main(void)
{
    int A, B;
    printf("Enter a number for a: ");
    scanf("%d", &A);
    printf("Enter a number for b: ");
    scanf("%d", &B);

    beautifulFunc(A, B);
    printf("\n");
    uglyFunc(&A, &B);
}
