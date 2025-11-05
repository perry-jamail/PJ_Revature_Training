# Create a list containing 5 elements. Create another list that has elements from the previous list containing the character ‘a’.

def listOfA(arr):
    returnList = []
    for i in arr:
        if "a" in i:
            returnList.append(i)

    return returnList

print(listOfA(["apples", "bees", "shoes", "barns"]))

# fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
# newlist = [x for x in fruits if "a" in x]