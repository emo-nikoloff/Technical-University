"""
Напишете програма, в която е описан клас. Обектите на класа трябва да имат поле, представляващо числов списък.
Този списък се формира на основата на списък, предаден като аргумент на конструктора. При това от списъка аргумент в списъка поле се включват само числовите елементи
(елементите от други типове се игнорират). Също така трябва да се дефинират два метода:
Първият метод показва съдържанието на полето списък, а вторият метод изчислява средната стойност на елементите на полето списък.
"""
class List:
    def __init__(self, value):
        self.listValues = value

    def display(self):
        print(f"Лист: {self.listValues}")
        for vals in self.listValues:
            if type(vals) != int:
                self.listValues.remove(vals)
        print(f"Лист само с числови елементи: {self.listValues}")

    def average(self):
        count = 0
        summation = 0
        for numbers in self.listValues:
            count += 1
            summation += numbers
        print(f"Средна стойност на числата в списъка: {summation / count}")

myList = List([1, 2, 3, "Емо", 6])
myList.display()
myList.average()
