"""Напишете програма, в която потребителя въвежда текст. От този текст се изтриват най-дългата и най-късата дума."""
text = input("Текст: ")
words = text.split()
longestWord = max(words, key = len)
shortestWord = min(words, key = len)
words.remove(longestWord)
words.remove(shortestWord)
print(f"Новият текст: {words} след премахването на най-дългата дума: {longestWord} и най късата: {shortestWord}")
