def divide():
    a = input("Enter first number: ")
    b = input("Enter second number: ")

    try:
        result = int(a)/int(b)
    except ZeroDivisionError:
        print("Cannot divide by zero.\n")
        divide()
    except ValueError:
        print("Must only enter numbers\n")
        divide()
    else:
        print(f"Dividing first number by second number equals {int(result)}")

divide()