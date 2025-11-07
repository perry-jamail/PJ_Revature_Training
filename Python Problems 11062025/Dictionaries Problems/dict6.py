dict1 = {
    'name': 'Harper',
    'age': 5,
    'hobby': 'Running'
}

def doesKeyExist(d):
    searchKey = input("Please enter the key you would like to search for: ")
    if searchKey in d:
        print(f"{searchKey} is in the dictionary")
    else:
        print(f"{searchKey} is not in the dictionary")

doesKeyExist(dict1)