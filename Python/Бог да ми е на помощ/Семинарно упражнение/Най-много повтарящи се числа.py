"""Напишете програма, която намира максимална редица от последователни еднакви елементи в списък и ги отпечатва."""
magicNumber = int(input())
myList = []
updatedList = []
count = 0
for numbers in range(1, magicNumber + 1):
    number = int(input())
    myList.append(number)

dictionary = {keys: myList.count(keys) for keys in myList}
print(dictionary)
