import json


my_data = {
    "name": "Alice",
    "age": 30,
    "city": "New York",
    "isStudent": False,
    "courses": ["Math", "Science"]
}

# Open a file in write mode ('w'). If the file doesn't exist, it will be created.
# If it exists, its content will be overwritten.
with open('data.json', 'w') as file:
    json.dump(my_data, file, indent=4)