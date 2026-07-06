"""
Въвеждаме цяло положително число n(определя броя на елементите в листа), запълваме листа с цели числа, след което намираме сумата на елементите от листа,
чиято стойност е кратна на 3 и е нечетна. Намираме индекса на max четно и min нечетно число. Сортираме листа в низходящ ред и намираме броя на отрицателните числа в листа.
"""
magicNumber = int(input("Магическо число: "))
myList = []

for _ in range(magicNumber):
    myList.append(int(input("Число: ")))
print(f"Лист: {myList}")

evenList = []
oddList = []
sum = 0
count = 0
for number in range(0, len(myList)):
    if (myList[number] % 3 == 0 and myList[number] % 2 != 0):
        sum += myList[number]

    if (myList[number] % 2 == 0):
        evenList.append(myList[number])
    elif (myList[number] % 2 != 0):
        oddList.append(myList[number])

    if (myList[number] < 0):
        count += 1

print(f"Сумата е: {sum}")
print(f"Индекс на максимално четно число: {myList.index(max(evenList))}")
print(f"Индекс на минимално нечетно число: {myList.index(min(oddList))}")
myList.sort(reverse=True)
print(f"Листът в низходящ ред: {myList}")
print(f"Брой отрицателни числа: {count}")
