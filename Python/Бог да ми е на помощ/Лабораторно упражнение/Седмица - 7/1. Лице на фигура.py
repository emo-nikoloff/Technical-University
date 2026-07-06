"""
Напишете програма, която изчислява лице на фигура. Фигурата може да е квадрат, правоъгълник или правоъгълен триъгълник.
За пресмятането на лицето на отделните фигури, напишете отделни функции.
"""
figure = input("Фигура: ")

def squareFace(side):
    return (side * side)
def rectangleFace(width, length):
    return (width * length)
def rightTriangleFace(width, length):
    return ((width * length) / 2)

if (figure == "квадрат"):
    squareSide = int(input("Страна: "))
    print(f"Лицето е: {squareFace(squareSide)}")
elif (figure == "правоъгълник"):
    rectangleWidth = int(input("Широчина: "))
    rectangleLength = int(input("Дължина: "))
    print(f"Лицето е: {rectangleFace(rectangleWidth, rectangleLength)}")
elif (figure == "правоъгълен триъгълник"):
    rightTriangleWidth = int(input("Широчина: "))
    rightTriangleLength = int(input("Дължина: "))
    print(f"Лицето е: {rightTriangleFace(rightTriangleWidth, rightTriangleLength)}")
