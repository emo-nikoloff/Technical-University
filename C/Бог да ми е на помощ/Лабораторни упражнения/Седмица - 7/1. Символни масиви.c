/*Дефинирайте 2 масива от тип char и използвайте главните функции от библиотеката string.h.*/
#include <stdio.h>
#include <string.h>

int main(void)
{
    char firstString[50], secondString[50];
    printf("Enter the first string:\n");
    scanf("%s", firstString);
    printf("Enter the second string:\n");
    scanf("%s", secondString);

    int firstLength = strlen(firstString);
    int secondLength = strlen(secondString);

    char concatenate[50];
    for (int i = 0; i < firstLength; i++)
    {
        concatenate[i] = firstString[i];
    }
    strcat(concatenate, secondString);

    int compare = strcmp(firstString, secondString);

    char copy[50];
    for (int i = 0; i < firstLength; i++)
    {
        copy[i] = firstString[i];
    }
    strcpy(copy, secondString);

    printf("The first string is: %s\n", firstString);
    printf("The second string is: %s\n", secondString);
    printf("The first length is: %d\n", firstLength);
    printf("The second length is: %d\n", secondLength);
    printf("Concatenate the second string with the first: %s\n", concatenate);
    printf("Compare the two strings: %d\n", compare);
    printf("Copy the second string into the first:\n%s is now %s\n", firstString, copy);

    return 0;
}
