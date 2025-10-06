"""
Задача 1:
Дефинирайте class Person, в който обектите имат полета: име, фамилия, възраст, националност. Дефинирайте конструктор, който инициализира полетата на класа.
Ще добавите метода print_info(), който отпечатва имената и националността. Ще създадете 3 обекта от class Person и за всеки от обектите му ще извикате метода print_info().
Задача 2:
Добяваме към кода от първата задача class Student, който наследява class Person с две нови полета: университет и година на обучение. Ще предефинирате метода print_info(),
така че да отпечатва новите полета. Ще създадете 2 нови инстанции на новия клас и за тях извиквате метода print_info.
Задача 3:
Добавяме class Lector, наследник на class Person, с две нови полета: университет и стаж. Предефинирате метода print_info, за да участват новите полета.
Създавате 2 нови инстанции.
Задача 4:
Да добавим към кода от предните задачи в class Lector речник, в който ключ е факултетен номер на студент, а стойността е оценката му. В class Student добавяме поле fac_no.
В class Lector да се добави метод addStudent, добавящ студент с ключ факултетния номер и стойност 0 и метод setGrade,
който по факултетен номер поставя оценка на съответния студент. Да се предефинира за Lector методът print_info, така че да отпечатва студентите с оценките им.
Да се добави към класа на преподавателя метод averageGrade, който да изчисли средния успех на студентите и го отпечатва.
"""
class Person:
    def __init__(self, firstName, lastName, age, nationality):
        self.firstName = firstName
        self.lastName = lastName
        self.age = age
        self.nationality = nationality

    def print_info(self):
        print(f"Име: {self.firstName}, Фамилия: {self.lastName}, Години: {self.age}, Националност: {self.nationality},", end = " ")


print("Хора: ")
person1 = Person("Емилиян", "Николов", 19, "българин")
person2 = Person("Стоян", "Иванов", 16, "германец")
person3 = Person("Кемал", "Сойдере", 25, "турчин")

person1.print_info()
print()
person2.print_info()
print()
person3.print_info()
print()


class Student(Person):
    def __init__(self, firstName, lastName, age, nationality, university, studyYear, facultyNumber):
        Person.__init__(self, firstName, lastName, age, nationality)
        self.university = university
        self.studyYear = studyYear
        self.facultyNumber = facultyNumber

    def print_info(self):
        Person.print_info(self)
        print(f"Университет: {self.university}, Курс: {self.studyYear}, Факултетен номер: {self.facultyNumber}")


print()
print("Студенти: ")
student1 = Student("Стоян", "Иванов", 16, "германец", "ТУ - София", 1, 121224184)
student2 = Student("Кемал", "Сойдере", 25, "турчин", "ТУ - София", 1, 121235167)

student1.print_info()
student2.print_info()


class Lector(Person):
    def __init__(self, firstName, lastName, age, nationality, university, experience):
        Person.__init__(self, firstName, lastName, age, nationality)
        self.university = university
        self.experience = experience
        self.grades = {}

    def addStudent(self, student):
        self.grades[student.facultyNumber] = 0

    def setGrade(self, facultyNumber, grade):
        self.grades[facultyNumber] = grade

    def print_info(self):
        Person.print_info(self)
        print(f"Университет: {self.university}, Стаж: {self.experience} години")
        print()
        print("Оценки на студентите: ")
        for facultyNumber, grade in self.grades.items():
            print(f"Факултетен номер: {facultyNumber}, Оценка: {grade}")

    def averageGrade(self):
        if self.grades:
            average = sum(self.grades.values()) / len(self.grades)
            print(f"Среден успех на студентите: {average:.2f}")


print()
print("Лектор: ")
lector1 = Lector("Станислав", "Киряков", 32, "българин", "ТУ - София", 8)

lector1.addStudent(student1)
lector1.addStudent(student2)
lector1.setGrade(121224184, 5)
lector1.setGrade(121235167, 4)
lector1.print_info()
lector1.averageGrade()
