"""Напишете потребителска функция, която проверява дали едно число е палиндром и връща 1 и 0 ако не е."""
def checking(number):
    if (str(number) == str(number)[::-1]):
        return ("Числото е палиндром")
    else:
        return ("Числото не е палиндром")

magicNumber = int(input("Въведи число: "))
print(checking(magicNumber))
