#  Write script(s) to receive information from console input to create a dictionary, then append to a file.
#  Then, be able to read from the file and search for relevant data to return. Start with name search then can go to any data search.
import json


sendList = []

cont = 'y'
while cont == 'y':
    newDict = {
        'Name': input("Enter your name: "),
        'Age': input("Enter your age: "),
        'City': input("Enter your city: "),
        'Hobby': input("Enter your hobby: ")
    }
    sendList.append(newDict)

    cont = input("\nDo you have another person to enter into the dictionary? (y/n): ")

json_str = json.dumps(sendList, indent=4)

with open('people.json', 'w') as file:
    file.write(json_str)