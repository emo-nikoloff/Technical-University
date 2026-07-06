a = 3
b = 6
print("a = " + str(a) + "b = " + str(b) + "s = " + str(a * b))

b = 6.525
print("a = %d b = %.2f s = %.2f" % (a, b, a * b))

print("a = {:d} b = {:.3f} s = {:.3f}".format(a, b, a * b))

print(f"a = {a} b = {b:.2f} s = {(a * b):.2f}")
