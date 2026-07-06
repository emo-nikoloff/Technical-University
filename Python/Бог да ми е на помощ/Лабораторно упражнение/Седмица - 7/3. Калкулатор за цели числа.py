"""
Калкулатор за цели числа. Действията са събиране, изваждане, умножение, деление. Потребителя въвежда вида на операцията, след което 2 числа
и се принтира резултата от съответната операция. Функциите трябва да са lambda.
"""
operation = input("Операция: ")

summation = lambda n1, n2: n1 + n2
subtraction = lambda n1, n2: n1 - n2
multiplication = lambda n1, n2: n1 * n2
division = lambda n1, n2: n1 / n2

if (operation == "събиране"):
    firstNumber = int(input("Число: "))
    secondNumber = int(input("Число: "))
    print(f"Сборът е: {summation(firstNumber, secondNumber)}")
elif (operation == "изваждане"):
    firstNumber = int(input("Число: "))
    secondNumber = int(input("Число: "))
    print(f"Разликата е: {subtraction(firstNumber, secondNumber)}")
elif (operation == "умножение"):
    firstNumber = int(input("Число: "))
    secondNumber = int(input("Число: "))
    print(f"Произведението е: {multiplication(firstNumber, secondNumber)}")
elif (operation == "деление"):
    firstNumber = int(input("Число: "))
    secondNumber = int(input("Число: "))
    print(f"Делението е: {division(firstNumber, secondNumber)}")
