"""Напишете програма, която намира броя на повтарящите се числа."""
magicNumber = int(input())
myList = []
updatedList = []
count = 0
for numbers in range(1, magicNumber + 1):
    number = int(input())
    myList.append(number)

dictionary = {keys: myList.count(keys) for keys in myList}
print(dictionary)
