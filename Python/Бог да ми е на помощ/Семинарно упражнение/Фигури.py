"""
Напишете програма, която изчислява лицето и обиколката на фигура от
въведено число n(1 - квадрат, 2 - правоъгълник, 3 - правоъгълен триъгълник).
"""
number = int(input("Число: "))

if (number == 1):
    length = int(input("Дължина: "))
    width = length
    S = length * width
    P = 4 * length
    print(f"Лице: {S}")
    print(f"Обиколка: {P}")
elif (number == 2):
    length = int(input("Дължина: "))
    width = int(input("Широчина: "))
    S = length * width
    P = length * 2 + width * 2
    print(f"Лице: {S}")
    print(f"Обиколка: {P}")
elif (number == 3):
    length = int(input("Дължина: "))
    width = int(input("Широчина: "))
    side = int(input("Страна: "))
    S = (length * width) // 2
    P = length + width + side
    print(f"Лице: {S}")
    print(f"Обиколка: {P}")
else:
    exit()
