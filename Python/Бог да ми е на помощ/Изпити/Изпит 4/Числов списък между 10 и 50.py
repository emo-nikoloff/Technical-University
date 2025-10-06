"""
Напишете програма, в която потребителя въвежда цяло положително число n(10<n<50) и се създава списък с n на брой елементи.
Използвайте try-except, за да проверите дали n е валидно и дали отговаря на условието. Списъкът се запълва с цели числа от потребителя, като числата трябва да са в интервала [a;b],
където "a" е случайно число в интервала от -2500 до -1300, а "b" е случайно число в интервала от 1111 до 4444.
Да се намери броя на отрицателните елементи от списъка, чиято цифра на десетиците е кратна на 4 или 5. Да се намери средноаритметичното на елементите от списъка,
чиято стойност е двуцифрена и е четна.
Да се създаде втори списък и в него да се включат тези елементи от първия списък, които са трицифрени и са кратни на 3. Да се намери броя на елементите с нечетна стойност,
които са с четен индекс от списъка. Да се заменят всички елементи от списъка, които са с нечетен индекс с числото 13. Да се сравняват дължините на списъците, ако са с различна дължина,
от по-дългия да се изтрият първия и последния елемент. Да се направят необходимите проверки при работа с двата списъка.
"""
from random import randint

while True:
    try:
        magicNumber = int(input("Брой елементи в списъка: "))
        if magicNumber <= 10 or magicNumber >= 50:
            raise ArithmeticError
        break
    except ValueError:
        print("ВЪВЕДЕТЕ ЧИСЛО!!!")
    except ArithmeticError:
        print("Числото трябва да е по-голямо от 10 и по-малко от 50!")

a = randint(-2500, -1300)
b = randint(1111, 4444)

myFirstList = []
while len(myFirstList) < magicNumber:
    element = int(input(f"Въведете число в интервала от {a} до {b}: "))
    if a <= element <= b:
        myFirstList.append(element)
print(f"Първи списък: {myFirstList}")

counter = 0
for element in myFirstList:
    if element < 0:
        if abs(element) < 10:
            continue
        elif abs(element) < 100:
            if abs(element) % 10 == 4 or abs(element) % 10 == 5:
                counter += 1
        elif abs(element) < 1000:
            tens = abs(element) // 10
            if tens % 10 == 4 or tens % 10 == 5:
                counter += 1
        elif abs(element) >= 1000:
            tens = abs(element) // 100
            if tens % 10 == 4 or tens % 10 == 5:
                counter += 1
print(f"Брой отрицателните елементи, чиято цифра на десетиците е кратна на 4 или 5: {counter}")

summation = 0
for element in myFirstList:
    sumFractions = 0
    if abs(element) < 10:
        continue
    elif abs(element) < 100:
        tens = abs(element) % 10
        digits = abs(element) // 10
        sumFractions = digits + tens
    elif abs(element) < 1000:
        hundreds = abs(element) % 10
        tens = (abs(element) // 10) % 10
        digits = abs(element) // 100
        sumFractions = digits + tens + hundreds
    elif abs(element) >= 1000:
        thousands = abs(element) % 10
        hundreds = (abs(element) // 10) % 10
        tens = (abs(element) // 100) % 10
        digits = abs(element) // 1000
        sumFractions = digits + tens + hundreds + thousands
    if sumFractions >= 10 and sumFractions % 2 == 0:
        summation += element
print(f"Cредноаритметичното на елементите от списъка, чиято стойност е двуцифрена и е четна: {summation / len(myFirstList):.2f}")

mySecondList = []
for element in myFirstList:
    if 1000 > abs(element) >= 100 and abs(element) % 3 == 0:
        mySecondList.append(element)
print(f"Втори списък: {mySecondList}")

counter = 0
for element in range(len(mySecondList)):
    if mySecondList[element] % 2 != 0 and element % 2 == 0:
        counter += 1
print(f"Брой елементи с нечетна стойност, които са с четен индекс: {counter}")

for element in range(len(mySecondList)):
    if element % 2 != 0:
        mySecondList[element] = 13
print(f"Вторият списък след заместването на числата с нечетен индекс с числото 13: {mySecondList}")

if len(myFirstList) > len(mySecondList):
    myFirstList.pop(0)
    myFirstList.pop(-1)
    print(f"Първият списък след премахването на първия и последния елемент: {myFirstList}")
elif len(myFirstList) < len(mySecondList):
    mySecondList.pop(0)
    mySecondList.pop(-1)
    print(f"Вторият списък след премахването на първия и последния елемент: {mySecondList}")
