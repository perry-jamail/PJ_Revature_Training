# Given two numbers a and b, you need to swap their values so a holds the value of b and b holds the
# value of a. Just write the code to swap values of a and b at the specified place.

def valSwap(a, b):
    c = a
    a = b
    b = c
    print(f"a = {a}, b = {b}")

valSwap(1, 2)