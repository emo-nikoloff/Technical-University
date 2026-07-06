"""
Николай трябва да провери дали е възможно да се образува триъгълник от представените страни с условна дължина.
За да направи това, той реши да създаде class TriangleChecker, който приема само положителни числа. Методът is_triangle() връща следните стойности (в зависимост от ситуацията):
– Ура, можете да построите триъгълник!
– Нищо няма да работи с отрицателни числа!
– Трябва да въведете само числа!
– Жалко, но не можете да направите триъгълник от това!
"""
class TriangleChecker:
    def __init__(self, side1, side2, side3):
        self.firstSide = side1
        self.secondSide = side2
        self.thirdSide = side3

    def isTriangle(self):
        try:
            if self.firstSide < 0 or self.secondSide < 0 or self.thirdSide < 0:
                print("Нищо няма да работи с отрицателни числа!")
            elif (self.firstSide > (self.secondSide + self.thirdSide) or self.secondSide > (self.firstSide + self.thirdSide) or self.thirdSide > (self.firstSide + self.secondSide)):
                print("Жалко, но не можете да направите триъгълник от това!")
            else:
                print("Ура, можете да построите триъгълник!")
        except TypeError:
            print("Трябва да въведете само числа!")

triangle = TriangleChecker(15, 16, 17)
triangle.isTriangle()
