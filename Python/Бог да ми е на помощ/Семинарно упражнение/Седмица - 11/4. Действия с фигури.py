"""
Дефинирайте class Shape с едно поле задаващо вида на фигурата. Дефинирайте class Square и class Circle, които наследяват Shape.
class Square и class Circle имат предефинирана функция __init__, която приема дължина(или радиус) като аргумент.
И трите класа имат метод за намиране на лице, като лицето на Shape е 0 по подразбиране. Потребителя въвежда вида на фигурата и на тази база се създава обект от съответния клас.
След това се извиква метода за намиране на лице за съответния обект. Добавете обработка на изключения.
"""
from math import pi

class Shape:
    def __init__(self, figure):
        self.figureType = figure

class Square(Shape):
    def __init__(self, figure, side):
        Shape.__init__(self, figure)
        self.length = side

    def face(self):
        print(f"Лице на квадрат: {self.length * 4}")

class Circle(Shape):
    def __init__(self, figure, radius):
        Shape.__init__(self, figure)
        self.radius = radius

    def face(self):
        print(f"Лице на кръг: {pi * self.radius * self.radius:.2f}")

shape = input("Въведи вид фигура: ")
if shape == "квадрат":
    square = Square("квадрат", int(input("Въведи страна на квадрат: ")))
    square.face()
elif shape == "кръг":
    circle = Circle("кръг", int(input("Въведи радиус на кръг: ")))
    circle.face()
