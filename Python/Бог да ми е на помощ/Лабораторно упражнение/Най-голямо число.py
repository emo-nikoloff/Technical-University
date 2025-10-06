"""Напишете програма, която чете цели числа и намира най-голямото."""
end = int(input("Край: "))

maxNumber = 0
for i in range(end):
    number = int(input("Число: "))
    if (number > maxNumber):
        maxNumber = number
print(f"Най-голямото число е: {maxNumber}")
