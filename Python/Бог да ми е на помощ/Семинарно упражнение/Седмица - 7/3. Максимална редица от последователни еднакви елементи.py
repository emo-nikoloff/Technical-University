"""Напишете програма, която намира максимална редица от последователни еднакви елементи в списък и ги отпечатва."""
myList = []
magicNumber = int(input("Магическо число: "))

for n in range(1, magicNumber + 1):
    number = int(input("Число: "))
    myList.append(number)

maxCount = 0
maxElement = None
counter = 1
result = []

if len(myList) > 0:
    for i in range(1, len(myList)):
        if myList[i] == myList[i - 1]:
            counter += 1
        else:
            if counter > maxCount:
                maxCount = counter
                maxElement = myList[i - 1]
            counter = 1

    if counter > maxCount:
        maxCount = counter
        maxElement = myList[-1]

    if maxElement is not None:
        result = [maxElement] * maxCount

print(f"Това са еднаквите елементите, които са най-много на брой едни след други: {result}")
