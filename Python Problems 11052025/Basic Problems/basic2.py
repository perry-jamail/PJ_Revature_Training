# Given three inputs that are stored in the variables a, b, and c. You need to print a a times and b b
# times  in a single line separated by c.

def multiPrint(a, b, c):
    for i in range(a):
        print(a, end = "")

    print(c, end = "")

    for i in range(b):
        print(b, end = "")

multiPrint(5,10,15)