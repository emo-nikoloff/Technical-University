"""
Напишете програма, в която потребителя въвежда цяло многоцифрено положително число. На база това число се формират 2 кортежа.
В първия кортеж влизат цифрите на числото в прав ред, а във втория кортеж влизат цифрите на числото в обратен ред.
"""
magicNumber = int(input("Магическо число: "))
if (magicNumber < 10):  # не е задължително
    exit()

tuple1 = ()
tuple2 = ()

firstTuple = list(tuple1)
secondTuple = list(tuple2)
for digit in range(len(str(magicNumber))):
    firstTuple.append(int(str(magicNumber)[digit]))
    secondTuple.append(int(str(magicNumber)[digit]))
tuple1 = tuple(firstTuple)
tuple2 = tuple(secondTuple)

print(tuple1)
print(tuple(reversed(tuple2)))
