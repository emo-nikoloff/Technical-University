"""Напишете програма, която намира максимална редица от последователни еднакви елементи в списък и ги отпечатва."""
def maxSequenceOfEqualElements(list):
    maxCount = 0
    maxElement = None
    counter = 1

    for numbers in range(1, len(list)):
        if list[numbers] == list[numbers - 1]:
            counter += 1
        else:
            if counter > maxCount:
                maxCount = counter
                maxElement = list[numbers - 1]
            counter = 1

    if counter > maxCount:
        maxCount = counter
        maxElement = list[-1]

    if maxElement is not None:
        return [maxElement] * maxCount
    else:
        return []

myList = []
magicNumber = int(input("Магическо число: "))
for n in range(1, magicNumber + 1):
    number = int(input("Число: "))
    myList.append(number)
print(f"Това са еднаквите елементите, които са най-много на брой едни след други: {maxSequenceOfEqualElements(myList)}")
