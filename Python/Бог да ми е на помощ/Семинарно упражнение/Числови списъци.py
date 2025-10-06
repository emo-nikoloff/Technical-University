"""
Напишете програма, в която се създава функция с 2 аргумента, явяващи се числови списъци.
Резултатът се явява число равно на сумата от двойките произведения на елементите на списъците.
Ако в един от списъците елементите са по-малко от другия, то недостигащите елементи се получават посредством циклично повторение на съдържанието на списъка.
"""
def numberList(firstList, secondList):
    firstListLen = len(firstList)
    secondListLen = len(secondList)
    minLen = min(firstListLen, secondListLen)

    resultList = []
    list1 = firstList
    list2 = secondList
    for i in range(minLen):
        frstList = list1[i]
        scndList = list2[i]
        resultList.append(frstList * scndList)

    if firstListLen > secondListLen or secondListLen > firstListLen:
        for j in range(abs(firstListLen - secondListLen)):
            resultList.append(0)
    return resultList

myFirstList = [1, 2, 3]
mySecondList = [1, 2, 3, 4, 5, 6]
result = numberList(myFirstList, mySecondList)
print(f"Първи лист: {myFirstList}")
print(f"Втори лист: {mySecondList}")
print(f"Резултат от произведението: {result}")
