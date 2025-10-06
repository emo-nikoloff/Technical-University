"""
Да се напише програма, в която се създава числов списък с n на брой елементи, като n се въвежда от потребителя и n е цяло число между 15 и 35 (15<n<35).
Използвайте try-expect, за да проверите дали n е валидно и дали отговаря на условието. Списъкът се запълва с положителни цели числа от потребителя,
като числата трябва да са в интервала от 30 до 300. Да се намери броят на елементите от списъка, чиято цифра на десетиците е кратна на 3.
Да се намери индекса на минималния елемент от този списък, който има остатък 4 при целочислено деление на 6.
Да се създаде втори списък и в него да се включат тези елементи от първия списък, които са двуцифрени и са кратни на 2 или 3.
Да се намери средноаритметичното на елементите от списъка, чиито индекси са нечетни. Да се изтрие минималното четно число от този списък.
В началото на списъка да се добави нов елемент, чиято стойност е равна на произведението от максималното нечетно число и минималното нечетно число от този списък.
"""
myList = []
while True:
    try:
        magicNumber = int(input("Брой елементи в списъка: "))
        if 15 < magicNumber < 35:
            while magicNumber > 0:
                try:
                    number = int(input("Число: "))
                    if 30 <= number <= 300:
                        myList.append(number)
                        magicNumber -= 1
                    else:
                        raise ValueError
                except ValueError:
                    print("Числото трябва да е цяло и да е в интервала от 30 до 300!")
            break
        else:
            raise ValueError
    except ValueError:
        print("Числото трябва да е между 15 и 35!")
print(f"Лист: {myList}")

counter = 0
for numbers in myList:
    if numbers > 99:
        removeThirdDigit = numbers // 10
        ten = removeThirdDigit % 10
        if ten % 3 == 0:
            counter += 1
    else:
        ten = numbers % 10
        if ten % 3 == 0:
            counter += 1
print(f"Брой числа, чиито десетици са кратни на 3: {counter}")

minimum = 301
for minNumbers in myList:
    if minNumbers % 6 == 4 and minNumbers < minimum:
        minimum = minNumbers
print(f"Индексът на най-малкото число с остатък 4 при деление на 6: {myList.index(minimum)}")

print()

mySecondList = []
for newNumbers in myList:
    if newNumbers < 100 and newNumbers % 2 == 0 or newNumbers % 3 == 0:
        mySecondList.append(newNumbers)
print(f"Лист 2: {mySecondList}")

summation = 0
for oddIndexes in range(len(mySecondList)):
    if oddIndexes % 2 != 0:
        summation += mySecondList[oddIndexes]
average = summation / len(mySecondList)
print(f"Средноаритметично на числата от втория списък на нечетни позиции: {average:.2f}")

newMinimum = 301
for minEvenNumbers in mySecondList:
    if minEvenNumbers % 2 == 0 and minEvenNumbers < newMinimum:
        newMinimum = minEvenNumbers
mySecondList.remove(newMinimum)
print(f"Лист 2 след премахването на най-малкото четно число: {mySecondList}")

maximum = 29
minimal = 301
for oddNumbers in mySecondList:
    if oddNumbers % 2 != 0 and oddNumbers > maximum:
        maximum = oddNumbers
    if oddNumbers % 2 != 0 and oddNumbers < minimal:
        minimal = oddNumbers
newElement = maximum * minimal
mySecondList.insert(0, newElement)
print(f"Лист 2 след добавянето на нов елемент в началото: {mySecondList}")
