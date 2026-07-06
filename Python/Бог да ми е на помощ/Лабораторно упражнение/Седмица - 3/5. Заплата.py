"""Въвеждаме брой работни часове за ден и заплащане за час, след което изчисляваме и принтираме брутното заплащане."""
workingHoursForDay = int(input("Брой работни часове за ден: "))
salaryForHour = float(input("Заплащане за час: "))
print(f"Заплата за ден: {workingHoursForDay * salaryForHour} лв. Заплата за месец: {workingHoursForDay * salaryForHour * 22} лв.")
