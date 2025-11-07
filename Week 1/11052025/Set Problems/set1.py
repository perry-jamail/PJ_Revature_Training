# You are given an array arr[] of size n. You have to insert all elements of arr[] into a set and return that set.
# You are also given an integer x. If x is found in set then erase it from set and print "erased x", otherwise, print "not found".

def changeToSet(arr):
    return set(arr)

def eraseFromSet(set1, x):
    if x in set1:
        set1.remove(x)
        print(f"erased {x}")
    else:
        print("not found")

print(changeToSet([1,2,3,4,5,6,7]))
eraseFromSet(changeToSet([1,2,3,4,5,6,7]), 5)
eraseFromSet(changeToSet([1,2,3,4,5,6,7]), 8)