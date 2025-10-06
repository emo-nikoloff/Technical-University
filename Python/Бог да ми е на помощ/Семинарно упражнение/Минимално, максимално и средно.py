"""Напишете програма, в която потребителя въвежда n-число, след това n-числа и намира min, max и average."""
number = int(input("Край: "))

maxNumber = 0
minNumber = 54354325467236732409
averageNumber = 0
for numbers in range(number):
    n = int(input("Число: "))
    if (n > maxNumber):
        maxNumber = n

    if (n < minNumber):
        minNumber = n

    averageNumber += n

print(maxNumber)
print(minNumber)
averageNumber //= number
print(averageNumber)
