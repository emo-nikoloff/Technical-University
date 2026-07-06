"""
Напишете програма меню, реализираща работа с английско-български речник. Потребителя има следните опции:
- може да търси дума на английски и да получи превода на български, ако търсената дума не е в речника, тогава тази дума да се добави в речника
- може да добави дума в речника
- може да види цялото съдържание на речника
- може да изтрие дума от речника
Програмата продължава до въвеждане на "Exit".
"""

# Изработено от: Емилиян Николов - 42a - 121224184
dictionary = {}

def searchWord():
    word = input("Въведи дума на английски: ")
    if word in dictionary:
        print(f"Преводът на {word} е {dictionary[word]}")
    else:
        print(f"Думата {word} не е в речника.")
        add = input("Искате ли да добавите превода на български на думата?: ")
        if add == "да":
            translation = input("Въведете превод на български: ")
            dictionary[word] = translation
            print(f"Думата {word} е добавена с превод {translation}.")

def addWord():
    word = input("Въведи дума на английски: ")
    if word in dictionary:
        print(f"Думата {word} вече е добавена с превод {dictionary[word]}")
    else:
        translation = input("Въведете превод на български: ")
        dictionary[word] = translation
        print(f"Думата {word} е добавена с превод {translation}.")

def checkDictionary():
    if dictionary:
        print("Съдържание на речника: ")
        for word, translation in dictionary.items():
            print(f"{word} - {translation}")
    else:
        print("Речникът е празен")

def deleteWord():
    word = input("Въведете дума на английски за изтриване: ")
    if word in dictionary:
        del dictionary[word]
        print(f"Думата {word} е изтрита от речника.")
    else:
        print(f"Думата {word} не е намерена в речника.")

while (True):
    print("Английско-български речник:")
    print("1. Превод на дума")
    print("2. Добавяне на дума към речника")
    print("3. Преглед на речника")
    print("4. Изтриване на дума")
    print("5. Затваряне на речника")
    myChoice = int(input("Избери опция: "))

    if (myChoice == 1):
        searchWord()
        print()
    elif (myChoice == 2):
        addWord()
        print()
    elif (myChoice == 3):
        checkDictionary()
        print()
    elif (myChoice == 4):
        deleteWord()
        print()
    elif (myChoice == 5):
        exit("Затваряне на речника")
    else:
        print("Опитай пак")
        print()
