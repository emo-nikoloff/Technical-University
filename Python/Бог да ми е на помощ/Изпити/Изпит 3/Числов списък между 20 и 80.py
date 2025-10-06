"""
Напишете програма, в която се създава числов списък с n на брой елементи, като n се въвежда от потребителя и n е цяло число между 20 и 80(20<n<80).
Използвайте try-except, за да проверите дали n е валидно и дали отговаря на условието. Списъкът се запълва със случайни цели числа в интервала [-800 до 1000].
Да се намери броят на елементите от списъка, чиято цифра на стотиците е кратна на 3. Да се намери индекса на най-голямото отрицателно и на най-малкото положително число от този списък.
Да се създаде втори списък и в него да се включат тези елементи от първия списък, чиято стойност е кратна на 7 и е нечетна.
Да се намери средноаритметичното на елементите от този списък, чиито индекси са четни. Да се принтират отрицателните двуцифрени числа от този списък.
Да се изтрие елемента с максимална отрицателна стойност от този списък.
"""
from random import randint

while True:
    try:
        magicNumber = int(input("Елементи в списъка: "))
        if magicNumber <= 20 or magicNumber >= 80:
            raise ArithmeticError
        break
    except ValueError:
        print("Приемат се само числа!")
    except ArithmeticError:
        print("Стойността трябва да е по-голяма от 20 и по-малка от 80!")

firstList = []
for element in range(magicNumber):
    firstList.append(randint(-800, 1000))
print(f"Списъкът със случайни елемнти: {firstList}")

count = 0
for element in firstList:
    if element > 999:
        fraction = element // 100
        hundreds = fraction % 10
        if hundreds % 3 == 0:
            count += 1
    elif abs(element) < 100:
        continue
    else:
        if (abs(element) // 100) % 3 == 0:
            count += 1
print(f"Елементите от списъка, чиято цифра на стотиците е кратна на 3: {count}")

maximum = -801
minimum = 1001
for element in firstList:
    if maximum < element < 0:
        maximum = element
    elif 0 <= element < minimum:
        minimum = element
print(f"Индекса на най-голямото отрицателно - {firstList.index(maximum)} и на най-малкото - {firstList.index(minimum)} положително число от този списък ")

secondList = []
for element in firstList:
    if element % 7 == 0 and element % 2 != 0:
        secondList.append(element)
print(f"Втори списък: {secondList}")

summation = 0
count = 0
for element in range(len(secondList)):
    if element % 2 == 0:
        summation += secondList[element]
        count += 1
if len(secondList) > 0:
    print(f"Средноаритметичното на елементите, чиито индекси са четни {summation / count:.2f}")
else:
    print("Вторият списък е празен, затова не може да се намери средноаритметично на елементите, чиито индекси са четни!")

print("Отрицателните двуцифрени числа:")
found = False
for element in secondList:
    if element < 0 and 10 <= abs(element) < 100:
        found = True
        print(element)
if not found:
    print("Няма отрицателни двуцифрени числа!")

maximum = 0
for element in secondList:
    if element < 0 and abs(element) > abs(maximum):
        maximum = element

if maximum != -801 and maximum in secondList:
    secondList.remove(maximum)
    print(f"Вторият списък след изтриването на елемента с максимална отрицателна стойност: {secondList}")
else:
    if len(secondList) == 0:
        print("Вторият списък е празен, затова не може да се изтрие елемента с максимална отрицателна стойност!")
    else:
        print("Във втория списък няма отрицателни числа, затова не може да се изтрие елемента с максимална отрицателна стойност!")
