# Write a python script to copy the contents of one file to another

with open('text.txt', 'r') as file:
    text = file.read()

with open('text2.txt', 'w') as file2:
    file2.write(text)