"""
Дефинирайте class Car с полета: car_brand(марка), car_model(модел), car_price(цена), car_colour(цвят), manifacture_year(година на производство). Да се дефинира конструктор,
който инициализира полетата на класа. В класа е дефиниран и метод: display_info(self), който показва информация за автомобил. Да се създаде списък с име cars, който съдържа 7 инстанции на
class Car. Да се съставят следните функции:
- sort_price - извършва сортиране по цена на автомобил в низходящ ред и извежда получения резултат на екрана
- list_by_brand - получава като аргумент марка на автомобил и извежда на екрана всички автомобили от дадената марка
- search_colour - получава като аргумент цвят на автомобил и връща като резултат най-скъпия автомобил със зададения цвят.
- newest_car - връща като резултат списък с автомобили, чиято година на производство е 2022.
"""

class Car:
    def __init__(self, car_brand, car_model, car_price, car_colour, manifacture_year):
        self.brand = car_brand
        self.model = car_model
        self.price = car_price
        self.colour = car_colour
        self.year = manifacture_year

    def display_info(self):
        print(f"Характеристики на автомобил: {self.brand}, {self.model}, {self.price}, {self.colour}, {self.year}")

def sort_price(carsPrice):
    carsPrice.sort(key = lambda cars: cars.price, reverse = True)
    for automobiles in carsPrice:
        automobiles.display_info()

def list_by_brand(brand):
    for cars in carsList:
        if brand == cars.brand:
            cars.display_info()

def search_colour(colour):
    maxPrice = 0
    for cars in carsList:
        if cars.colour == colour and cars.price > maxPrice:
            maxPrice = cars.price
            maxPricedCar = cars
            return maxPricedCar.display_info()

def newest_car():
    newestCarsList = []
    for cars in carsList:
        if cars.year == 2022:
            newestCarsList.append(cars)
    if newestCarsList:
        print("\nСписък с най-новите автомобили:")
        for newestCars in newestCarsList:
            newestCars.display_info()

carsList = []
for automobile in range(7):
    try:
        car = Car(input("Марка: "), input("Модел: "), float(input("Цена: ")), input("Цвят: "), int(input("Година на производство: ")))
        carsList.append(car)
    except ValueError:
        print("Моля, въведете коректни стойности!")
for car in carsList:
    car.display_info()

print("\nАвтомобилите подредени по цена в низходящ ред:")
sort_price(carsList)

list_by_brand(input("\nМарка автомобил: "))

search_colour(input("\nЦвят на автомобил: "))

newest_car()
