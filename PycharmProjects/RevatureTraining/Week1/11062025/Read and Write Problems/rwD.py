#  Write script(s) to receive information from console input to create a dictionary, then append to a file.
#  Then, be able to read from the file and search for relevant data to return. Start with name search then can go to any data search.
import json

with open('people.json', 'r') as file:
    data = json.load(file)

searchTerm = input("Enter the name of the person you would like to search for: ")
for d in data:
    if d['Name'] == searchTerm:
        print(d)
    elif d['Age'] == searchTerm:
        print(d)
    elif d['City'] == searchTerm:
        print(d)
    elif d['Hobby'] == searchTerm:
        print(d)
