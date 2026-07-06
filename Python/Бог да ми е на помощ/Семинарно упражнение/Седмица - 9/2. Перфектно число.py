"""
Перфектното число е положително цяло число, което е равно на сумата от своите положителни делители.
Напишете програма, която да отпечата всички перфектни числа, присъстващи в даден списък.
За целта създайте функция checkPerfectNum(), която получава като аргумент цяло положително число.
Функцията връща като резултат True, ако числото е перфектно и False, ако не е перфектно.
"""
def checkPerfectNum(perfectNum):
    summary = 0
    for checker in range(1, perfectNum):
        if perfectNum % checker == 0:
            summary += checker
    if summary == perfectNum:
        return True
    else:
        return False

if checkPerfectNum(int(input("Въведете число: "))):
    print("числото е перфектно ;)")
else:
    print("числото не е перфектно ;(")
