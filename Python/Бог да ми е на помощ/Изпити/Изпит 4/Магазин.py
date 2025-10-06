"""
Да се състави програма на Python, чрез която се дефинира class Market(хранителен магазин) с полета: barcod(баркод), name(име), manufacturer(производител), price(цена), quantity(количество).
Да се създаде конструктор, който инициализира полетата на класа. В класа са дефинирани и методи:
 - sale(self, quantity) за продажба на определен брой от тези продукти,
 - discount(self), който прилага отстъпка към цената на продукта, по следния начин:
  -> ако цената на продукта е между 50 и 30 лв.(включително) - отстъпката е 5% от цената
  -> ако цената на продукта е между 30 и 10 лв.(включително) - отстъпката е 7% от цената
  -> ако цената на продукта е под 10 или над 50 лв. - няма отстъпка
Да се създаде списък product_list, който съдържа n инстанции на class Market(n се въвежда от потребителя). Да се дефинират следните функции:
 - search_by_barcod() - получава като аргумент списък с обекти от class Market и число(баркод). Принтира цялата информация за съответния продукт, ако не е намерен продукт с търсения баркод
 се принтира следното съобщение: "Wrong barcode!!!" и информация за наличните баркодове от списъка.
 - search_by_manufacturer() - получава като аргумент списък с обекти от class Market и производителя на продукта и връща като резултат списък с всички продукти от производителя,
 с цена по-ниска или равна на средната цена на продуктите от производителя.
 - search_by_quantity() - получава като аргумент списък с обекти от class Market. Сортира продуктите по количество във възходящ ред и извежда получения резултат на екрана.
 - search_by_name() - получава като аргумент списък с обекти от class Market и име. Изтрива от списъка всички продукти, които са с посоченото име и чието количество е по-малко или равно на 3.
"""

class Market:
    def __init__(self, barcod, name, manufacturer, price, quantity):
        self.barcod = barcod
        self.name = name
        self.manufacturer = manufacturer
        self.price = price
        self.quantity = quantity
        self.__newQuantity = 0

    def sale(self, quantity):
        if self.quantity >= quantity:
            self.__newQuantity = quantity
            self.quantity -= self.__newQuantity
            return True
        return False

    def discount(self):
        if 30 <= self.price <= 50:
            self.price -= self.price * 0.05
        elif 10 <= self.price < 30:
            self.price -= self.price * 0.07

    def get_newQuantity(self):
        return self.__newQuantity

def question(list):
    while True:
        try:
            money = float(input("\nКолко е бюджета ви: "))
            break
        except ValueError:
            print("Моля, въведете валиден бюджет!")

    counter = 0
    while counter < len(list):
        try:
            for creation in list:
                answer = input(f"\nИскате ли да закупите от {creation.name}: ")
                if answer.lower() == "да":
                    creation.discount()
                    while True:
                        try:
                            quantity = int(input(f"Колко искате да закупите от {creation.name}: "))
                            if creation.sale(quantity):
                                break
                            else:
                                print(f"Недостатъчна бройка за продажба от {creation.name}\n")
                        except ValueError:
                            print("Моля, въведете валидно количество!")
                    money -= creation.get_newQuantity() * creation.price
                    if money >= 0:
                        print(f"Закупихте {creation.get_newQuantity()} бройки от {creation.name}! Останаха {creation.quantity}")
                        print(f"Останаха ви {money:.2f} лева!")
                        counter += 1
                    else:
                        print("Недостатъчен бюджет!")
                        counter += 1
                elif answer.lower() == "не":
                    counter += 1
                else:
                    raise ValueError
            print()
            print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        except ValueError:
            print("Моля, въведете да или не!")

def search_by_barcod(myList, barcod):
    found = False
    for creation in myList:
        if creation.barcod == barcod:
            print(f"~~Информация за {creation.name} с баркод {creation.barcod}~~\nПроизводител: {creation.manufacturer}\nЦена: {creation.price:.2f} лева\nКоличество: {creation.quantity}\n")
            print("~~~~~~~~~~~~")
            found = True
            break
    if not found:
        print("~~Няма продукт със зададения баркод!~~")
        print("Налични баркодове:")
        for p in myList:
            print(p.barcod)
        print()
        print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

def search_by_manufacturer(myList, manufacturer):
    summation = 0
    for creation in myList:
        if creation.manufacturer == manufacturer:
            summation += creation.price

    printer = f"~~Всички продукти от {manufacturer} с цена по-ниска или равна на средната цена на продуктите от {manufacturer}~~"
    print(printer)
    found = False
    for creation in myList:
        if creation.manufacturer == manufacturer and creation.price <= summation / len(myList):
            print(f"Баркод: {creation.barcod}\nИме: {creation.name}\nПроизводител: {creation.manufacturer}\nЦена: {creation.price:.2f} лева\nКоличество: {creation.quantity}")
            found = True
            print()
    if not found:
        print(f"Няма налични продукти от {manufacturer}")
        print()
    for printing in range(len(printer)):
        print("~", end = "")
    print()

def search_by_quantity(myList):
    myList.sort(key = lambda creation: creation.quantity, reverse = False)
    print("\n~~Продуктите подредени във възходящ ред по количество~~")
    for creations in myList:
        print(f"Баркод: {creations.barcod}\nИме: {creations.name}\nПроизводител: {creations.manufacturer}\nЦена: {creations.price:.2f} лева\nКоличество: {creations.quantity}")
    print()
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

def search_by_name(myList, name):
    found = False
    for creation in myList:
        if creation.name == name and creation.quantity <= 3:
            myList.remove(creation)
            print(f"Успешно премахнахте {name} от магазина си.")
            found = True
    if not found:
        print(f"Съжаляваме, но нямаме {name} тук!")
    print()
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

product_list = []
magicNumber = int(input("Брой продукти: "))
while magicNumber <= 0:
    magicNumber = int(input("Брой продукти: "))
for products in range(magicNumber):
    while True:
        try:
            barcode = int(input("Баркод: "))
            break
        except ValueError:
            print("Моля, въведете валиден баркод!")
    product = input("Име на продукт: ")
    creator = input("Производител: ")
    while True:
        try:
            cost = float(input("Цена: "))
            break
        except ValueError:
            print("Моля, въведете валидна цена!")
    while True:
        try:
            amount = int(input("Количество: "))
            break
        except ValueError:
            print("Моля, въведете валидно количество!")
    product_list.append(Market(barcode, product, creator, cost, amount))

print("~~Продукти~~")
print()
for products in product_list:
    print(f"Баркод: {products.barcod}\nИме: {products.name}\nПроизводител: {products.manufacturer}\nЦена: {products.price:.2f} лева\nКоличество: {products.quantity}")
    print()
print("~~~~~~~~~~~~")

question(product_list)

while True:
    try:
        search_by_barcod(product_list, int(input("\nБаркод за проверка: ")))
        break
    except ValueError:
        print("Моля, въведете валиден баркод!")

search_by_manufacturer(product_list, input("\nПроизводител за проверка: "))

search_by_quantity(product_list)

search_by_name(product_list, input("\nИме на продукт за проверка: "))

print("\033[31m~~Магазинът затвори! Довиждане!~~\033[0m")
