"""
Дефинираме class Student с полета name, facNumber и programmingLanguage. Дефинираме функция, която получава аргумент обект от class Student.
Функцията добавя в текстов файл информацията за студента.
"""
class Student:
    def __init__(self, name, facultyNumber, programmingLanguage):
        self.name = name
        self.facNumber = facultyNumber
        self.programLanguage = programmingLanguage

    def __str__(self):
        return f"Студентът е {self.name} с факултетен номер - {self.facNumber} и изучава програмния език - {self.programLanguage}"

firstStudent = Student("Емилиян", "121224184", "Python")
print(f"Функция: {firstStudent}")

with open("Студент.txt", "w+") as file:
    file.write(f"Файл: {firstStudent}")
    file.seek(0)
    print(file.read())
    file.close()
