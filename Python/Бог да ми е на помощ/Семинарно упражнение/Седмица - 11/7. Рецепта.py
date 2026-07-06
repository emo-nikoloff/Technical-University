"""
Създайте class Food с полета carbs, protein и fat, които се инициализират при създаването на обект от класа.
В класа е добавен метод calories(), който изчислява броят на калориите в обект от класа, по следната схема:
4 калории за грам въглехидрати, 4 калории за всеки грам протеин и 9 калории за грам мазнини.
Създайте class Recipe. Обектите от класа имат поле name(наименование на рецептата) и поле, представляващо списък с обекти от class Food, наречен ingredients.
Добавете метод в класа, наречен calories(), който връща общият брой на калориите за дадена рецепта. Добавете __str__ метод в class Recipe, който връща името на рецептата.
Създайте n на брой обекти от class Recipe, като n се въвежда от потребителя и е цяло число по-голямо от 4 и по-малко от 15.
За всяка една от рецептите отпечатайте името на рецептата и общият брой на калориите за тази рецепта. Добавете обработка на изключения, там където е необходимо.
"""
class Food:
    def __init__(self, carbs, protein, fat):
        self.carbohydrates = carbs
        self.proteins = protein
        self.fats = fat

    def calories(self):
        return 4 * self.carbohydrates + 4 * self.proteins + 9 * self.fats

class Recipe:
    def __init__(self, name, ingredients):
        self.recipeName = name
        self.ingredients = ingredients

    def calories(self):
        return sum(ingredient.calories() for ingredient in self.ingredients)

    def __str__(self):
        return self.recipeName

while True:
    try:
        recipesNumber = int(input("Брой рецепти(между 5 и 14): "))
        if 5 <= recipesNumber <= 14:
            break
        else:
            print("Числото трябва да бъде между 5 и 14!")
    except ValueError:
        print("Моля, въведете валидно цяло число!")

recipes = []
for dish in range(recipesNumber):
    myRecipeName = input("Въведете име на рецепта: ")
    components = []

    componentsNumber = int(input(f"Колко съставки има в рецептата за {myRecipeName}: "))
    for component in range(1, componentsNumber + 1):
        print(f"Въведете информация за съставка {component}:")
        ingredientCarbs = float(input("Грамове въглехидрати: "))
        ingredientProteins = float(input("Грамове протеини: "))
        ingredientFats = float(input("Грамове мазнини: "))
        components.append(Food(ingredientCarbs, ingredientProteins, ingredientFats))

    myRecipe = Recipe(myRecipeName, components)
    recipes.append(myRecipe)

for recipe in recipes:
    print(f"Рецепта: {recipe}, Калории: {recipe.calories()}")
