/*Потребителя въвежда 10 числа в масив от 20 елемента. След това въвежда числа, като с всяко въведено число указва индекса, където да бъде вмъкнато това число
(числото избутва останалите). Въвеждането спира при вход 0 (нула) или при запълване на масива.*/
#include <stdio.h>

int main(void)
{
    int tempArray[20];
    int length = sizeof(tempArray) / sizeof(tempArray[0]);
    int size = 0;
    for (int i = 0; i < length - 10; i++)
    {
        printf("Enter element: ");
        scanf("%d", &tempArray[i]);
        size++;
    }

    int array[20];
    for (int i = 0; i < length - 10; i++)
    {
        array[i] = tempArray[i];
    }

    int index;
    while (index != 0)
    {
        printf("Enter index: ");
        scanf("%d", &index);
        if (index < 0 || index > 19)
        {
            printf("The index should be 0 <-> 19\n");
        }
        else
        {
            printf("Enter element: ");
            scanf("%d", &array[index]);
            for (int i = 0; i < length; i++)
            {
                if (index == i)
                {
                    array[i + 1] = array[i];
                    array[i] = array[index];
                }
            }
            size++;
            if (size == length)
            {
                break;
            }
        }
    }

    for (int i = 0; i < length; i++)
    {
        printf("array[%d]: %d\n", i, array[i]);
    }

    return 0;
}
