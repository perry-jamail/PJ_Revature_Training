# Given two inputs that are stored in variables a and n, you need to print a,
# n times in a single line without space between them. Output must have a newline at the end.

def multiPrint(a, n):
    for i in range(n):
        print(a, end="")

multiPrint('a', 20)