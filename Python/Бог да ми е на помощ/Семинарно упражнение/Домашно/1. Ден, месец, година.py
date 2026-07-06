"""Напишете програма, в която се въвежда днешната дата, месецът и годината, ден от седмицата(1 - M, 2 - T, ...) и колко дни са отминали от началната ни дата(> 0 и < 365)."""
# e-mail: TU.HA.HRISTOV@gmail.com

# Изработено от: Емилиян Николов - 42a - 121224184
date = int(input("Дата: "))
month = int(input("Месец: "))
year = int(input("Година: "))
dayOfWeek = int(input("Ден от седмицата: "))
futureDays = int(input("Дни в бъдещето: "))

dayOfTheWeek = ""
if (dayOfWeek == 1):
    dayOfTheWeek = "Понеделник"
elif (dayOfWeek == 2):
    dayOfTheWeek = "Вторник"
elif (dayOfWeek == 3):
    dayOfTheWeek = "Сряда"
elif (dayOfWeek == 4):
    dayOfTheWeek = "Четвъртък"
elif (dayOfWeek == 5):
    dayOfTheWeek = "Петък"
elif (dayOfWeek == 6):
    dayOfTheWeek = "Събота"
elif (dayOfWeek == 7):
    dayOfTheWeek = "Неделя"
else:
    exit("Невалиден ден от седмицата!")

if (date < 10 and month < 10):
    print(f"Започнахме на 0{date}/0{month}/{year} - {dayOfTheWeek}.")
elif (date < 10):
    print(f"Започнахме на 0{date}/{month}/{year} - {dayOfTheWeek}.")
elif (month < 10):
    print(f"Започнахме на {date}/0{month}/{year} - {dayOfTheWeek}.")
else:
    print(f"Започнахме на {date}/{month}/{year} - {dayOfTheWeek}.")

for nextMonth in range(futureDays):
    if (month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12):
        date += 1
        if (date > 31):
            month += 1
            date = 1
    elif (month == 4 or month == 6 or month == 9 or month == 11):
        date += 1
        if (date > 30):
            month += 1
            date = 1
    elif (month == 2):
        if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
            date += 1
            if (date > 29):
                month += 1
                date = 1
    else:
        date += 1
        if (date > 28):
            month += 1
            date = 1

countWeeks = 0
newDayOfTheWeek = ""
for weeks in range(futureDays):
    dayOfWeek += 1
    if (dayOfWeek > 7):
        countWeeks += 1
        dayOfWeek = 1

    if (dayOfWeek == 1):
        newDayOfTheWeek = "Понеделник"
    elif (dayOfWeek == 2):
        newDayOfTheWeek = "Вторник"
    elif (dayOfWeek == 3):
        newDayOfTheWeek = "Сряда"
    elif (dayOfWeek == 4):
        newDayOfTheWeek = "Четвъртък"
    elif (dayOfWeek == 5):
        newDayOfTheWeek = "Петък"
    elif (dayOfWeek == 6):
        newDayOfTheWeek = "Събота"
    elif (dayOfWeek == 7):
        newDayOfTheWeek = "Неделя"
    else:
        exit("Невалиден ден от седмицата!")

if (month > 12):
    exit("Съжаляваме, но календарът отчита само за тази година!")
elif (futureDays <= 0):
    exit("Съжаляваме, но трябва да въведете валидни дни!")

if (date < 10 and month < 10):
    print(f"Днес е 0{date}/0{month}/{year}. Денят от седмицата е {newDayOfTheWeek}. Отминаха {futureDays} дни и {countWeeks} седмици от началната ни дата.")
elif (date < 10):
    print(f"Днес е 0{date}/{month}/{year}. Денят от седмицата е {newDayOfTheWeek}. Отминаха {futureDays} дни и {countWeeks} седмици от началната ни дата.")
elif (month < 10):
    print(f"Днес е {date}/0{month}/{year}. Денят от седмицата е {newDayOfTheWeek}. Отминаха {futureDays} дни и {countWeeks} седмици от началната ни дата.")
else:
    print(f"Днес е {date}/{month}/{year}. Денят от седмицата е {newDayOfTheWeek}. Отминаха {futureDays} дни и {countWeeks} седмици от началната ни дата.")
# по мое желание реших да търся и изминали седмици
