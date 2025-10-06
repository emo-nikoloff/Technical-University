"""
Да се състави програма за мениджмънт на магазин за обувки. За целта създайте class Shoes с полета: brand(марка), price(цена), colour(цвят), size(размер), quantity(количество).
В класа са дефинирани методите: Sale(self, quantity) за продажба на определен брой от тези обувки. Purchase(self, quantity) за зареждане на ново количество обувки.
Да се създаде списък с името shoes_list, който съдържа 7 инстанции на class Shoes. Да се съставят следните функции:
- sort_price - получава като аргумент списък с обекти от class Shoes, като извършва сортиране по цена в низходящ ред и извежда получения резултат на екрана
- shoes_searching - получава като аргумент списък с обекти от class Shoes, марка и размер. Връщайки резултат списък с всички обувки,
които са от тъсрената марка и размер и са с цена по-малка от средноаритметичната стойност на обувките от списъка
- cheapest_shoes - получава като аргумент списък с обекти от class Shoes и цвят на обувки. Принтира на екрана информация за най-евтините обувки с търсения цвят.
Ако няма обувки с търсения, тогава принтира на екрана съобщение "colour is not available" и информация за наличните цветове на обувки от списъка
- delete_shoes - получава като аргумент списък с обекти от class Shoes и марка на обувки, изтрива от списъка всички обувки от дадената марка
"""

class Shoes:
    def __init__(self, brand, price, colour, size, quantity):
        self.brand = brand
        self.price = price
        self.colour = colour
        self.size = size
        self.quantity = quantity

    def Sale(self, quantity):
        if self.quantity >= quantity:
            self.quantity -= quantity
            print(f"Продадохте {quantity} чифта от марката {self.brand}. Останаха {self.quantity} чифта.")
        elif self.quantity < quantity:
            print(f"Недостатъчно обувки!")

    def Purchase(self, quantity):
        self.quantity += quantity
        print(f"Заредихте {quantity} чифта от марката {self.brand}. Сега те станаха {self.quantity} на брой.")

def sort_price(shoes):
    shoes.sort(key = lambda footwear: footwear.price, reverse = True)
    print("Сортиране по цена в низходящ ред:")
    for _ in shoes_list:
        print(f"{_.brand}, {_.price}, {_.colour}, {_.size}, {_.quantity}")

def shoes_searching(shoes, brand, size):
    summation = 0
    count = 0
    for _ in shoes:
        summation += _.price
        count += 1
    summation /= count
    print(f"Това са обувките от марката {brand} с размер {size} и цена по-малка от средноаритметичната стойност на наличните обувки:")
    for _ in shoes:
        if _.brand == brand and _.size == size and _.price < summation:
            print(f"{_.brand}, {_.price}, {_.colour}, {_.size}, {_.quantity}")

def cheapest_shoes(shoes, colour):
    print(f"Това са най-евтините обувки с цвят {colour}:")
    minimum = 12482395328564129
    for _ in shoes:
        if _.colour == colour:
            if _.price < minimum:
                minimum = _.price
                print(f"{_.brand}, {_.price}, {_.colour}, {_.size}, {_.quantity}")
        else:
            print("Цветът не е наличен!")
            break
    for _ in shoes:
        if _.colour != colour:
            print(f"Налични цветове: {_.colour}")

def delete_shoes(shoes, brand):
    for _ in shoes:
        if _.brand == brand:
            shoes.remove(_)
    print(f"Изтрихте информацията за обувките от марката {brand}.")

shoes_list = []
for shoe in range(7):
    shoes_list.append(Shoes(input("Марка: "), float(input("Цена: ")), input("Цвят: "), float(input("Размер: ")), int(input("Количество: "))))

for soldShoe in shoes_list:
    soldShoe.Sale(int(input(f"Количество за продаване от марката {soldShoe.brand} обувки: ")))

for purchasedShoe in shoes_list:
    purchasedShoe.Purchase(int(input(f"Количество за закупуване от марката {purchasedShoe.brand}: ")))

sort_price(shoes_list)
shoes_searching(shoes_list, input("Марка за проверка: "), float(input("Размер за проверка: ")))
cheapest_shoes(shoes_list, input("Цвят за проверка: "))
delete_shoes(shoes_list, input("Марка за проверка: "))
