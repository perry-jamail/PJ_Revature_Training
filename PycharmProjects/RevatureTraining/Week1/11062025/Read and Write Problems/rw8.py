import json

# Open the JSON file in read mode ('r')
with open('data.json', 'r') as f:
    # Load the JSON data from the file into a python dictionary
    data = json.load(f)

# now, 'data' is a python dictionary containing the information form data.json
print(data)