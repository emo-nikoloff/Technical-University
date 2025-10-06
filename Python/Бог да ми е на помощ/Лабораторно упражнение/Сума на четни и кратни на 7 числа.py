"""Напишете програма, в която се въвеждат n числа и се намира сумата на четните и кратни на 7 числа."""
end = int(input("Край: "))

sum = 0
for _ in range(1, end + 1):
    number = int(input("Число: "))
    if (number % 2 == 0 and number % 7 == 0):
        sum += number
print(f"Сумата на всички четни числа и кратни на 7: {sum}")
