# Appending to a file:
# Use "a" mode to add content to the end of an existing file without deleting its contents.

with open("output.txt", "a") as file:
    file.write("This line is appended.\n")