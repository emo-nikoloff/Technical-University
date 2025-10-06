"""Дефинирайте функция, която намира НОК на 2 числа, функцията получава като аргумент 2 числа и връща резултат НОК на тези числа."""
def LCM(firstNumber, secondNumber):
    myList = []
    for nums in range(2, min(firstNumber, secondNumber)):
        while (firstNumber % nums == 0 or secondNumber % nums == 0):
            myList.append(nums)
            if firstNumber % nums == 0:
                firstNumber //= nums
            if secondNumber % nums == 0:
                secondNumber //= nums
        if firstNumber == 1 and secondNumber == 1:
            break
    print(f"Делители: {myList}")

    summation = 1
    for nums in myList:
        summation *= nums
    return summation

print(f"НОК: {LCM(int(input("Въведи първо число: ")), int(input("Въведи второ число: ")))}")
