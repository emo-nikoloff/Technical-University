/*Харалампий иска да организира рожден ден, но за целта трябва да закупи инвентар за провеждането, който се изразява в следните предмети:
- Стол - 13,99
- Маса за 8 човека - 42,00
- комплект от 6 чаши - 5,98
- комплект от 6 чинии с прибори - 21,02
От клавиатурата се въвеждат броя на гостите. Следват редове с неща, които до момента е купил Харалампий за партито до въвеждане на команда PARTY!. Сметнете колко пари е похарчил до момента
Харалампий и колко още неща трябва да купи, за да може да реализира своето парти и всички гости да имат стол, да седят на маса и да разполагат с чаша и прибори.*/
#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
    double chair = 13.99, table = 42.00, setCups = 5.98, setPlatesWithCutlery = 21.02;
    int guests;
    printf("Enter the number of guests: ");
    scanf("%d", &guests);

    int chairs = 0, tables = 0, cups = 0, plates = 0;
    while (1) {
        char item[50];
        printf("Enter an item: ");
        scanf("%s", item);
        if (strcmp(item, "PARTY!") == 0) {
            break;
        }

        if (strcmp(item, "Chair") == 0 || strcmp(item, "chair") == 0) {
            chairs++;
        } else if (strcmp(item, "Table") == 0 || strcmp(item, "table") == 0) {
            tables++;
        } else if (strcmp(item, "Cups") == 0 || strcmp(item, "cups") == 0) {
            cups++;
        } else if (strcmp(item, "Plates") == 0 || strcmp(item, "plates") == 0) {
            plates++;
        }
    }

    printf("There are %d guests equipped with %d tables, %d chairs, %d sets of cups and %d sets of plates.\n", guests, tables, chairs, cups, plates);

    double sum = chair * chairs + table * tables + setCups * cups + setPlatesWithCutlery * plates;
    if (chairs >= guests && tables * 8 >= guests && cups * 6 >= guests && plates * 6 >= guests) {
        printf("Everything is set!\n");
    } else {
        if (chairs < guests) {
            printf("You need %d more chairs.\n", (guests - chairs));
        }
        if (tables * 8 < guests) {
            int neededTables = (int) ceil((double) guests / 8);
            printf("You need %d more tables because a table is for 8 people.\n", (neededTables - tables));
        }
        if (cups * 6 < guests) {
            int neededCups = (int) ceil((double) guests / 6);
            printf("You need %d more sets of cups because a set contains 6 cups.\n", (neededCups - cups));
        }
        if (plates * 6 < guests) {
            int neededPlates = (int) ceil((double) guests / 6);
            printf("You need %d more sets of plates because a set contains 6 plates with cutleries.\n", (neededPlates - plates));
        }
    }

    printf("Total spent: %.2lf BGN\n", sum);
    return 0;
}
