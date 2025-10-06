"""Въвеждаме число и се принтира дали е отрицателно, положително или 0."""
number = int(input("Число: "))

if (number == 0):
    print(f"Числото е {number}")
elif (number > 0):
    print(f"Числото {number} е положително")
else:
    print(f"Числото {number} е отрицателно")
