#include <stdio.h> // в <> се поставя файл, който съдържа нужните функции за работата на кода

// Функции:
void myFunction() // ако видът на функцията е void не се връща резултат
{
    printf("Calling a function\n\n");
}

void sex(char name[], char gender[], int age)
{
    printf("%s is a %s and is %d years old\n", name, gender, age);
}

int x = 5; // глобална променлива

void something()
{
    int x = 22;
    printf("Print the variable x: %d\n", x); // ще принтира локалната променлива
}

int calculate(int firstNumber, int secondNumber); // задаваме функцията

// Структури:
struct date
{
    int day; // член
    int month;
    int year;
};

struct Name
{
    char firstName[50];
    char secondName[50];
    char lastName[50];
};

struct Person
{
    struct Name names;
    int age;
    char gender;
};

int main() // главна функция - изпълнява се кодът
{
    printf("-------------------\n"); // принтира въведеното
    // Променливи:
    int myInt;
    printf("Enter an integer: ");
    scanf("%d", &myInt); // позволява на потребителя да въвежда стойности
    // първо се изписва спецификатора, а след това променливата, като задължително се слага & пред нея (съхранява адресът на променливата); може вместо %d да използваме %i
    float myFloat;
    printf("Enter a floating point number: ");
    scanf("%f", &myFloat); // може вместо %f да използваме %F
    double myDouble;
    printf("Enter a double: ");
    scanf("%lf", &myDouble);
    getchar(); // изчиства новия ред, който scanf() е предизвикал, от буфера и позволява да се прочете символът
    char myChar;
    printf("Enter a character: ");
    scanf("%c", &myChar); // друг вариант е просто да сложим празно място пред спецификатора, за да игнорираме оставащия нов ред - 'scanf(" %c", &myChar);'

    printf("My integer: %d\n", myInt); // следващия принт не преминава на нов ред, затова е хубаво да слагаме \n на края на настоящия принт
    printf("My floating point number: %.2f\n", myFloat); // .(цифра) пред спецификатора показва колко цифри да има след запетаята
    printf("My double: %.2lf\n", myDouble);
    printf("My symbol: %c\n", myChar);

    //* Размер на променливите:
    printf("\n");
    printf("The memory size of the int is %llu bytes\n", sizeof(myInt));
    printf("The memory size of the float is %llu bytes\n", sizeof(myFloat));
    printf("The memory size of the double is %llu bytes\n", sizeof(myDouble));
    printf("The memory size of the char is %llu bytes\n", sizeof(myChar));

    printf("-------------------\n");

    // Оператори:
    int firstNumber = 4;
    int secondNumber = 2;
    //-> Аритметични:
    //<-> Събиране: +
    printf("%d + %d = %d\n", firstNumber, secondNumber, firstNumber + secondNumber);
    //<-> Изваждане: -
    printf("%d - %d = %d\n", firstNumber, secondNumber, firstNumber - secondNumber);
    //<-> Умножение: *
    printf("%d * %d = %d\n", firstNumber, secondNumber, firstNumber * secondNumber);
    //<-> Деление: /
    printf("%d / %d = %d\n", firstNumber, secondNumber, firstNumber / secondNumber);
    //<-> Модулно деление: % - резултатът е остатъкът от делението
    printf("%d %% %d = %d\n\n", firstNumber, secondNumber, firstNumber % secondNumber);

    //-> За сравнение: връща 1(True) или 0(False)
    //<-> Равенство: ==
    printf("%d = %d ?: %d\n", firstNumber, secondNumber, firstNumber == secondNumber);
    //<-> Различно: !=
    printf("%d != %d ?: %d\n", firstNumber, secondNumber, firstNumber != secondNumber);
    //<-> По-голямо: >
    printf("%d > %d ?: %d\n", firstNumber, secondNumber, firstNumber > secondNumber);
    //<-> По-голямо или равно: >=
    printf("%d >= %d ?: %d\n", firstNumber, secondNumber, firstNumber >= secondNumber);
    //<-> По-малко: <
    printf("%d < %d ?: %d\n", firstNumber, secondNumber, firstNumber < secondNumber);
    //<-> По-малко или равно: <=
    printf("%d <= %d ?: %d\n\n", firstNumber, secondNumber, firstNumber < secondNumber);

    //-> Логически: връща 1(True) или 0(False)
    int thirdNumber = 1;
    //<-> И: && - връща 1(True), ако всички условия са True
    printf("%d < %d and %d ?: %d\n", thirdNumber, firstNumber, secondNumber, (thirdNumber < firstNumber) && (thirdNumber < secondNumber));
    //<-> Или: || - връща 1(True), ако поне едно условие е True
    printf("%d < %d or %d ?: %d\n", thirdNumber, firstNumber, secondNumber, (thirdNumber < firstNumber) || (thirdNumber < secondNumber));
    //<-> Отрицание: !
    printf("Reverse %d into %d\n", thirdNumber < firstNumber, !(thirdNumber < secondNumber));

    printf("-------------------\n");

    // Условия и твърдения:
    //-> if-твърдения:
    if (myInt < myFloat)
    {
        printf("%d is smaller than %.2f\n\n", myInt, myFloat);
    }
    else if (myInt > myFloat)
    {
        printf("%d is larger than %.2f\n\n", myInt, myFloat);
    }
    else
    {
        printf("%d is equal to %.2f\n\n", myInt, myFloat);
    }

    //-> switch-твърдения:
    int dayOfTheWeek;
    printf("Enter the day of the week: ");
    scanf("%d", &dayOfTheWeek);
    switch (dayOfTheWeek)
    {
        case 1:
            printf("Monday\n");
            break;
        case 2:
            printf("Tuesday\n");
            break;
        case 3:
            printf("Wednesday\n");
            break;
        case 4:
            printf("Thursday\n");
            break;
        case 5:
            printf("Friday\n");
            break;
        case 6:
            printf("Saturday\n");
            break;
        case 7:
            printf("Sunday\n");
            break;
        default:
            printf("Enter a valid day of the week!\n");
            break;
    }

    printf("-------------------\n");

    // Цикли:
    //-> for-цикли:
    printf("Print the numbers from 1 to 9:\n");
    for (int i = 1; i <= 9; i++) // начало; условие за изпълнение; стъпка
    {
        printf("%d ", i);
    }

    printf("\n\nPrint the numbers from 1 to 9:\n");
    for (int i = 1; i <= 9; i++)
    {
        printf("%d ", i);
        if (i == 5)
        {
            printf("\n-%d numbers are enough-", i);
            break; // приключва цикъла
        }
    }

    printf("\n\nPrint the numbers from 1 to 9 but skip random numbers:\n");
    for (int i = 1; i <= 9; i++)
    {
        if (i == 5 || i == 2 || i == 8)
        {
            continue; // продължава изпълнението на цикъла
        }
        printf("%d ", i);
    }

    //-> while-цикли:
    printf("\n\nPrint the numbers from 10 to 20:\n");
    int starter = 10;
    while (starter <= 20)
    {
        printf("%d ", starter);
        starter++;
    }

    printf("\n\nNow print the numbers after 20 until 30:\n");
    do
    {
        printf("%d ", starter);
        starter++;
    }
    while (starter <= 30);

    printf("\n-------------------\n");

    // Масиви: съхраняват няколко стойности в една променлива
    //-> Едномерен масив:
    int myNumbers[] = {25, 50, 75, 100}; // елементите вътре трябва да са от един вид променлива

    printf("Print the numbers from the first array:\n");
    for (int i = 0; i < 4; i++)
    {
        printf("%d ", myNumbers[i]);
    }

    int myLuckyNumbers[3]; // задаваме размер на масива
    myLuckyNumbers[0] = 3; // за да достъпим до елемент от масива използваме индекса на елемента; първият елемент е с индекс 0
    myLuckyNumbers[1] = 7;
    myLuckyNumbers[2] = 12;

    printf("\n\nPrint my lucky numbers from the second array:\n");
    for (int i = 0; i < 3; i++)
    {
        printf("%d ", myLuckyNumbers[i]);
    }

    double fractionalNumbers[] = {6.9, 4.20, 3.7, 12.21};
    int length = sizeof(fractionalNumbers) / sizeof(fractionalNumbers[0]); // размерът на масива(байтове * елементи) / размерът на първия елемент

    printf("\n\nPrint the fractional numbers from the third array:\n");
    for (int i = 0; i < length; i++)
    {
        printf("%.2lf ", fractionalNumbers[i]);
    }

    //-> Двумерен масив:
    int matrix[3][4] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 9, 1, 1}}; // матрица(таблица от редове и колони) - първото измерение са редовете, а второто колоните

    printf("\n\nMatrix:\n");
    for (int row = 0; row < 3; row++)
    {
        for (int col = 0; col < 4; col++)
        {
            printf("%d ", matrix[row][col]);
        }
        printf("\n");
    }

    printf("\n-------------------\n");

    //* Тъй като няма променлива за задаване на низ можем да го зададем по този начин
    char string[] = "Why there isn't a string variable?"; // създаваме масив от символи
    printf("%s\n", string);

    printf("-------------------\n");

    // Pointer-указател: променлива, която съхранява адресът на друга променлива като стойност
    int *pointer = &myInt;
    printf("The memory address of myInt (using a pointer) is: %p\n", pointer);
    printf("The value of myInt (using a pointer) is: %d\n", *pointer);

    printf("-------------------\n");

    //-> към Функции:
    myFunction();
    sex("Emiliyan", "man", 19);
    sex("Jimmy", "woman", 19);
    printf("\n");

    something();
    printf("\nPrint the variable x: %d\n\n", x); // ще принтира глобалната променлива

    int result[6];
    result[0] = calculate(5, 3);
    result[1] = calculate(8, 2);
    result[2] = calculate(15, 15);
    result[3] = calculate(9, 1);
    result[4] = calculate(7, 1);
    result[5] = calculate(1, 1);
    for (int i = 0; i < 6; i++)
    {
        printf("Result No.%d is %d\n", i + 1, result[i]);
    }

    printf("-------------------\n");

    //-> към Структури:
    struct date firstDate = {25, 03, 2005}; // достъпване на структурата, чрез създаване на променлива от нея
    struct date today;
    today.day = 9;
    today.month = 4;
    today.year = 2025;
    printf("On this day I was born: %d.%d.%d\n", firstDate.day, firstDate.month, firstDate.year);
    printf("\nOn this day we studied structures: %d.%d.%d\n\n", today.day, today.month, today.year);

    struct Person person = {{"Emiliyan", "Georgiev", "Nikolov"}, 20, 'M'};
    printf("Name: %s %s %s\n", person.names.firstName, person.names.secondName, person.names.lastName);
    printf("Age: %d\n", person.age);
    if (person.gender == 'M' || person.gender == 'm')
    {
        printf("Gender: Male\n");
    }
    else if (person.gender == 'F' || person.gender == 'f')
    {
        printf("Gender: Female\n");
    }
    else
    {
        printf("Wrong gender!!\n");
    }

    printf("-------------------\n");

    return 0; // слага край на главната функция
}

int calculate(int firstNumber, int secondNumber) // дефинираме функцията
{
    return firstNumber + secondNumber;
}
