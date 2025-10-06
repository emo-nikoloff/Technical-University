/*Четем множество низове и при всяко прочитане ги конкатенираме към втори низ. Към края на всеки низ добавяме нов ред. Четенето спира при вход стоп или до запълването на масива.
След това принтираме съдържанието на този низ.*/
#include <stdio.h>
#include <string.h>

int main(void)
{
    char string[50];
    char ourString[50] = "";
    while (1)
    {
        printf("Enter string: ");
        fgets(string, sizeof(string), stdin);
        if (strcmp(string, "stop\n") == 0)
        {
            break;
        }

        if ((strlen(ourString) + strlen(string)) < sizeof(ourString))
        {
            strcat(ourString, string);
        }
        else
        {
            printf("Not enough space in our string!\n\n");
            break;
        }
    }
    printf("The final string is:\n%s", ourString);

    return 0;
}
