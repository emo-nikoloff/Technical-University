"""
Програма, в която е дефинирана фунция. Във функцията се подават като аргументи 2 обекта от един и същ клас.
Всеки обект от класа има поле представляващо списък от цели числа. Функцията връща като резултат обект от същия клас.
Полето списък на този обект се получава посредством сумиране на съответните елементи от полетата списъци на обектите предадени като аргументи на функцията.
Ако в обектите аргументи, списъците са с различна дължина, тогава в обекта резултат списъкът ще бъде с по-голямата дължина и недостигащите елементи ще се запълват с 0.
"""
class Functions():
    def __init__(args, numbers):
        args.numbers = numbers

    def info(args):
        print(args.numbers)

def sumObjectives(objective1, objective2):
    firstObjectiveList = objective1.numbers
    secondObjectiveList = objective2.numbers

    firstObjectiveLen = len(objective1.numbers)
    secondObjectiveLen = len(objective2.numbers)
    minLen = min(firstObjectiveLen, secondObjectiveLen)

    resultList = []
    for i in range(minLen):
        firstList = firstObjectiveList[i]
        secondList = secondObjectiveList[i]
        resultList.append(firstList + secondList)
    return Functions(resultList)

firstObjective = Functions([1, 2, 3])
secondObjective = Functions([4, 5, 10, 13, 18])
print("Първи обект: ", end = "")
firstObjective.info()
print("Втори обект: ", end = "")
secondObjective.info()

result = sumObjectives(firstObjective, secondObjective)
print("Сума на списъците: ", end = "")
result.info()
