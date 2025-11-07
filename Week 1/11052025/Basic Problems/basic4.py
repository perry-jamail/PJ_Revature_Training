# You are given two integer variables x and y. You need to perform the following operations:
#
# p = x + y : Addition
# q = x - y : Subtraction
# r = x * y : Multiplication
# s = x / y : Division
# t = x % y : Modulo

def ops(x, y):
    print(f"Addition: {x + y}")
    print(f"Subtraction: {x - y}")
    print(f"Multiplication: {x * y}")
    print(f"Division: {x / y}")
    print(f"Modulo: {x % y}")

ops(10,5)