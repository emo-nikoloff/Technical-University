"""Имате два файла. В единия има текстово съдържание. Прочетете съдържанието на първия файл и запишeте във втория файл всички думи от първия файл, които започват с гласна буква."""
firstFile = open("Два файла_1.txt", "w")
# Примерен input: Има десет думи, две от които започват с гласна буква
firstFile.write(input("Въведи текст: "))
firstFile.close()

firstFile = open("Два файла_1.txt", "r")
listFirstFile = firstFile.read()
splitListFirstFile = listFirstFile.split()
firstFile.close()

secondFile = open("Два файла_2.txt", "w+")
vowels = ("а", "ъ", "о", "у", "е", "и", "А", "Ъ", "О", "У", "Е", "И")
for words in splitListFirstFile:
    if words.startswith(vowels):
        secondFile.write(f"{words} ")
secondFile.seek(0)
print(f"Думите с гласни букви от текста: {secondFile.read()}")
secondFile.close()
