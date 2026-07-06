"""Четем цяло положително число и чертаем триъгълник от числа според числото."""
number = int(input("Число: "))

for digit in range(1, number + 1):
    for numeral in range(1, digit + 1):
        print(numeral, end = " ")
    print()
