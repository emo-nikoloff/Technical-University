/*Напишете програма, коята дефинира структура Box. Структурата съдържа следните полета: ширина, дължина, височина и обем. Полето обем се изчислява. Да се декларира масив от тип структура Box с
10 елемента, да се запълнят елементите на масива със стойности от страна на потребителя. Да се принтира информацията за кутиите с най-малък и най-голям обем.*/
#include <limits.h>
#include <stdio.h>

struct Box
{
    int width;
    int length;
    int height;
    int volume;
};

int main(void)
{
    struct Box boxes[10];
    for (int i = 0; i < 10; i++)
    {
        printf("Enter box #%d width: ", i + 1);
        scanf("%d", &boxes[i].width);
        printf("Enter box #%d length: ", i + 1);
        scanf("%d", &boxes[i].length);
        printf("Enter box #%d height: ", i + 1);
        scanf("%d", &boxes[i].height);

        boxes[i].volume = boxes[i].width * boxes[i].length * boxes[i].height;
    }

    int max = INT_MIN, min = INT_MAX;
    for (int i = 0; i < 10; i++)
    {
        if (boxes[i].volume > max)
        {
            max = boxes[i].volume;
        }
        if (boxes[i].volume < min)
        {
            min = boxes[i].volume;
        }
    }

    for (int i = 0; i < 10; i++)
    {
        if (boxes[i].volume == max)
        {
            printf("Box #%d is the biggest box with volume: %dL\n", i + 1, boxes[i].volume);
        }
        else if (boxes[i].volume == min)
        {
            printf("Box #%d is the smallest box with volume: %dL\n", i + 1, boxes[i].volume);
        }
    }
}
