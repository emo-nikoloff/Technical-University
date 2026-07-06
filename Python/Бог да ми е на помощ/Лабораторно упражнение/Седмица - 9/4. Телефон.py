"""
Дефинирате class Telephone с полета: brand, model, price.
В класа е дефиниран метод, който принтира информация за телефон.
Създайте функция, която връща списък с обекти от class Telephone.
Създайте функция, която получава списък с обекти от class Telephone и връща като резултат обекта с максимална цена.
"""
class Telephone():
    def __init__(tel, brand, model, price):
        tel.brand = brand
        tel.model = model
        tel.price = price

    def info(tel):
        print(f"Телефон: Марка: {tel.brand}, Модел: {tel.model}, Цена: {tel.price:.2f}")

def phones(n):
    telephones = []
    for tels in range(n):
        brand = input("Марка: ")
        model = input("Модел: ")
        price = float(input("Цена: "))
        tel = Telephone(brand, model, price)
        telephones.append(tel)
    return telephones

def maxPrice(phone):
    return max(phone, key = lambda value: value.price)

mobiles = phones(n = int(input("Брой телефони: ")))
for telephone in mobiles:
    telephone.info()

maxPricedTelephone = maxPrice(mobiles)
print("Телефонът с най-висока цена:", end = " ")
maxPricedTelephone.info()
