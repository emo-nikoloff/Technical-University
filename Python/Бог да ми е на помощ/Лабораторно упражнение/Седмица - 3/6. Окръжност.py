"""Четем радиус и намираме лице и периметър на окръжност."""
from math import pi

radius = float(input("Радиус: "))
print(f"Лице на окръжност: {pi * radius * radius:.2f}\nПериметър на окръжност: {2 * pi * radius:.2f}")
