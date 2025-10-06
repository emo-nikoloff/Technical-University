"""
Напишете програма, в която се създава числов списък с n на брой елементи, като n се въвежда от потребителя и n е цяло число между 20 и 30(20<n<30).
Използвайте try-except, за да проверите дали n е валидно и дали отговаря на условието. Списъкът се запълва със случайни числа в интервала [-100 до 100].
Намерете сумата на елементите от списъка, чиито индекси са нечетни. Да се намери броят на елементите от списъка, чиято цифра на единиците е кратна на 2.
Намерете произведението на елементите с отрицателна стойност, които са четни.
Да се създаде втори списък и в него да се включат тези числа от първия списък, които са по-големи от n.
Да се намери разликата между елемента с максимална и елемента с минимална стойност във втория списък. Да се принтират нечетните числа от този списък и техния брой.
Да се изтрие елемента с минимална стойност от втория списък.
"""
from random import randint

while True:
    try:
        magicNumber = int(input("Въведи число: "))
        if magicNumber <= 20 or magicNumber >= 30:
            raise ArithmeticError
        break
    except ValueError:
        print("Приемат се само числа!")
    except ArithmeticError:
        print("Стойността трябва да е по-голяма от 20 и по-малка от 30!")
firstList = []
for numbers in range(magicNumber):
    firstList.append(randint(-100, 100))
print(f"Списъкът с {magicNumber} случайни елементи: {firstList}")

firstSum = 0
for index in range(len(firstList)):
    if index % 2 != 0:
        firstSum += firstList[index]
print(f"Сумата на елементите, чиито индекси са нечетни: {firstSum}")

firstCount = 0
secondSum = 1
secondList = []
for elements in firstList:
    if abs(elements) < 10:
        if abs(elements) % 2 == 0:
            firstCount += 1
    elif abs(elements) > 10:
        elementsUnits = abs(elements) // 10
        if abs(elementsUnits) % 2 == 0:
            firstCount += 1

    if elements < 0 and elements % 2 == 0:
        secondSum *= elements

    if elements > magicNumber:
        secondList.append(elements)
print(f"Броят на елементите, чиято цифра на единиците е кратна на 2: {firstCount}")
print(f"Произведението на елементите с отрицателна стойност, които са четни: {secondSum}")
print(f"Втори списък с елементи, които са по-големи от магическото число: {secondList}")
print(f"Разликата между елемента с максимална и елемента с минимална стойност във втория списък: {max(secondList) - min(secondList)}")

oddList = []
secondCount = 0
for elements in secondList:
    if elements % 2 != 0:
        oddList.append(elements)
        secondCount += 1
print(f"Нечетните числа от втория списък: {oddList}")
print(f"Броят на нечетните числа от втория списък: {secondCount}")
secondList.remove(min(secondList))
print(f"Втория списък след премахването на най-малкия елемент: {secondList}")
