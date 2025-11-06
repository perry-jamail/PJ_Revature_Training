# Creating a new file use "x" mode to create a new file.
# If the file already exists, it raises FileExistsError.

try:
    with open("output.txt", "x") as file:
        file.write("This file was just created.")
except FileExistsError:
    print("This file already exists.")