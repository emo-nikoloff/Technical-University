"""Четем цяло положително число и чертаем триъгълник от * според числото."""
number = int(input("Число: "))

for star in range(1, number + 1):
    print(star * "* ")
