"""
Задача 1:
Да се реализира система за управление на персонал в компания. За целта създайте class Employee, който ще се наследява от различни видове служители като Manager и Developer.
Обектите на класа имат атрибутите: name(име на служителя), position(позиция в компанията), salary(заплата). В класа е дефиниран метод display_info(),
който връща информация за служителя. Създайте class Manager и class Developer, които наследяват class Employee. class Manager има допълнително поле department(отдел на мениджъра),
както и методи:
calculate_bonus() — бонусът на мениджъра се изчислява като 10% от основната заплата плюс 1000 лв. за ръководството на екип
display_info() — връща информация за мениджъра, включително отдела.
Задача 2:
class Developer има поле programming_languages(списък с програмни езици, които знае програмистът), както и методи:
calculate_bonus() — бонусът на програмист се изчислява като 15% от основната заплата плюс 200 лв. за всеки програмен език, който владее
display_info() — връща информация за програмиста, включително списъка с програмни езици.
Създайте class Company с атрибут employees(списък със служители) и методи:
add_employee(employee) — метод за добавяне на служител в компанията
total_salary_expense() — метод за изчисляване на общите разходи за заплати на всички служители
display_all_employees() — метод за показване на информация за всички служители в компанията
"""
class Employee:
    def __init__(self, name, position, salary):
        self.name = name
        self.position = position
        self.salary = salary

    def display_info(self):
        return f"{self.name} е {self.position} във фирмата. Заплатата е {self.salary} лв."

class Manager(Employee):
    def __init__(self, name, position, salary, department):
        super().__init__(name, position, salary)
        self.department = department

    def calculate_bonus(self):
        managerSalary = self.salary + self.salary * 0.1 + 1000
        return managerSalary

    def display_info(self):
        return f"{Employee.display_info(self)} Работи в отдел {self.department}."

class Developer(Employee):
    def __init__(self, name, position, salary, programmingLanguages):
        super().__init__(name, position, salary)
        self.programLanguage = programmingLanguages

    def calculate_bonus(self):
        developerSalary = self.salary + self.salary * 0.15
        for language in self.programLanguage:
            developerSalary += 200
        return developerSalary

    def display_info(self):
        return f"{Employee.display_info(self)} Знае езиците: {self.programLanguage}."

class Company:
    def __init__(self, employees):
        self.employees = employees

    def add_employee(self, employee):
        self.employees.append(employee)

    def total_salary_expense(self):
        workersSalaries = 0
        for worker in self.employees:
            workersSalaries += worker.calculate_bonus()
        return workersSalaries

    def display_all_employees(self):
        for working in self.employees:
            print(f"{working.display_info()}\nСлед причисляване на бонусите заплатата е {working.calculate_bonus():.2f} лв.")

worker1 = Manager("Емилиян", "мениджър", 1600, "безопасност")
worker2 = Developer("Неджимидин", "разработчик", 800, ["C#", "Java", "Python"])

company = Company([])
company.add_employee(worker1)
company.add_employee(worker2)
company.display_all_employees()
print(f"Разходи за заплати: {company.total_salary_expense():.2f} лв.")
