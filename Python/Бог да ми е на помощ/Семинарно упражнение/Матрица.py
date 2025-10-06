"""
Да се напише програма, в която се създава матрица с цели числа с размерност(NxM), като N и M се въвеждат от потребителя,
да се запълни матрицата със случайни числа в интервала от 10 до 100. Да се изтрият ред и колона от тази матрица по избор на потребителя и да се принтира резултатната матрица.
"""
import random

N = int(input("Брой редове: "))
M = int(input("Брой колони: "))
matrix = [[random.randint(10, 100) for _ in range(M)] for _ in range(N)]
print(f"Матрица: {matrix}")
deleteRow = int(input("Премахване на ред: "))
deleteCol = int(input("Премахване на колона: "))

newMatrix = [row[:deleteRow] + row[deleteRow + 1:] for row in (matrix[:deleteCol] + matrix[deleteCol + 1:])]
print(f"Новата матрица: {newMatrix}")
