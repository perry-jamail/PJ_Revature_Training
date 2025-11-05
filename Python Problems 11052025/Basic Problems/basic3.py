# You need to perform three separate tasks based on the given input:
# String Input and Print: Take a text input as a string and print it as it is.
# Integer Input and Add: Take an integer input n, add 10 to it, and print the result.
# Float Input and Multiply: Take a floating-point number as input, multiply it by 10, and print the result.

def inputDiff(i):
    if type(i) == str:
        print(i)
    elif type(i) == int:
        print(i + 10)
    elif type(i) == float:
        print(i * 10)
    else:
        print("Input a string, int, or float.")

inputDiff("Hello")
inputDiff(5)
inputDiff(6.7)