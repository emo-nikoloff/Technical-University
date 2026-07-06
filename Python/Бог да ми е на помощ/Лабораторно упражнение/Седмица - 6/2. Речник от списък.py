"""
Въвеждаме цяло число. На база това число се създава списък. Елементите на списъка са числата от 1 до въведеното число.
Въз основа на този списък се създава речник, чиито ключове са елементите от списъка, а стойностите са същите елементи в обратен ред.
"""
magicNumber = int(input("Въведи число: "))

myList = []
for number in range(1, magicNumber + 1):
    myList.append(number)

reversedList = myList[::-1]
dictionary = {myList[keys]: reversedList[keys] for keys in range(len(myList))}
print(dictionary)
