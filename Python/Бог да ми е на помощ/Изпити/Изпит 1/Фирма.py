"""
Да се състави програма за управление на данните на работниците в строителна фирма. За целта създайте class Worker с полета: worker_num(служебен номер),
fname(име), lname(фамилия), work_experience_company(трудов стаж във фирмата ), total_years_experience(общ трудов стаж), salary(заплата), age(възраст). В класа са дефинирани и методи:
- worker_information(self), който показва информация за работника
- salary_bonus(self), който изчислява добавка към заплатата на работника, като бонуса се изчислява по следния начин:
ако работника е с трудов стаж между 5 и 10 години във фирмата получава бонус 1.5% към заплатата, ако е със стаж над 10 години във фирмата получава 2% допълнително,
ако е с трудов стаж под 5 години получава бонус 0.5 към заплатата.
Информацията за работниците във фирмата се съхранява в списък workers_list, като броя на работниците
и необходимата информация за всеки работник се въвеждат от клавиатурата. Да се дефинира функция search_by_num, която получава като аргумент списък с обекти от class Worker
и число (служебен номер). Функцията търси работник по служебен номер, връща True, ако има работник с този номер, в противен случай връща False.
Да се дефинира функция с име search_by_name_experience, която да извежда информация за всички работници с подадените като аргумент - име и стаж във фирмата.
Да се дефинира функция add_worker, която да добавя информация за нов работник в списъка. Функцията получава като аргумент списъка, в който ще се извърши добавянето и обект от class Worker.
Да се дефинира функция remove_worker, която изтрива информацията за работник по зададен служебен номер (аргумент на функцията). Като резултат се принтира текста „Information deleted !!!“,
ако има работник със зададения служебен номер, в противен случай се принтира текста „Wrong worker_num !!!“.
"""

class Worker:
    def __init__(worker, worker_num, fname, lname, work_experience_company, total_years_experience, salary, age):
        worker.workerNumber = worker_num
        worker.firstName = fname
        worker.lastName = lname
        worker.experience = work_experience_company
        worker.totalExperience = total_years_experience
        worker.salary = salary
        worker.age = age

    def worker_information(worker):
        print(f"Работникът със служебен номер {worker.workerNumber} се казва {worker.firstName} {worker.lastName}. "
              f"Има стаж {worker.experience} години във фирмата. Общият му стаж е {worker.totalExperience} години. Получава {worker.salary:.2f} лева заплата. На {worker.age} години е.")

    def salary_bonus(worker):
        if 5 <= worker.experience <= 10:
            bonus = worker.salary * 0.015
        elif worker.experience > 10:
            bonus = worker.salary * 0.02
        else:
            bonus = worker.salary * 0.005
        salary = worker.salary + bonus
        return salary

workerList = []

def worker_list(magicNumber):
    for person in range(magicNumber):
        worker = Worker(int(input("Cлужебен номер: ")), input("Име: "), input("Фамилия: "), int(input("Стаж във фирмата: ")), int(input("Общ стаж: ")), float(input("Заплата: ")), int(input("Възраст: ")))
        print()
        workerList.append(worker)
    for workers in workerList:
        workers.salary_bonus()
        workers.worker_information()

def search_by_num(working, number):
    for workers in working:
        if number == workers.workerNumber:
            return True
        else:
            return False

def search_by_name_experience(working, name, workExp):
    print(f"\nТова са работниците с име {name} и стаж {workExp} години във фирмата:")
    for workers in working:
        if name == workers.firstName and workExp == workers.experience:
            print(f"{workers.firstName} {workers.lastName} със стаж {workers.experience} години")
        else:
            print("Няма такива работници!")

def add_worker(working, worker):
    working.append(worker)

def remove_worker(working, number):
    for workers in working:
        if number == workers.workerNumber:
            working.remove(workers)
            print("Информацията е изтрита!")
            break
        else:
            print("Грешен служебен номер!")
            break

worker_list(int(input("Колко работника има във фирмата: ")))
print()
print(search_by_num(workerList, int(input("Проверка на работник по служебен номер: "))))
print()
search_by_name_experience(workerList, input("Име на работник: "), int(input("Стаж във фирмата: ")))
print(f"\nНазначаване на работник:")
add_worker(workerList, Worker(int(input("Cлужебен номер: ")), input("Име: "), input("Фамилия: "), int(input("Стаж във фирмата: ")), int(input("Общ стаж: ")), float(input("Заплата: ")), int(input("Възраст: "))))
remove_worker(workerList, int(input("Премахване на работник по служебен номер: ")))
