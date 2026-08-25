/*Функция, която намира дължината на низ без да използваме вградените функции.*/
#include <stdio.h>

int len(char array[])
{
    int i;
    for (i = 0; array[i] != '\0'; i++)
    {}
    return i;
}

int main(void)
{
    char string[50] = "Hello";
    printf("The length of the string is: %d\n", len(string));
    return 0;
}
