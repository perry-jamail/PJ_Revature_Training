import numpy as np


arr = np.array([1,2,3,4,5])

# normal slicing
print(arr[1:5])

# slicing with no end
print(arr[0:])

# slicing with no beginning
print(arr[:4])

# negative slicing
print(arr[-3:-1])

# step (returns every other element from indices 1-5)
print(arr[1:5:2])

# slicing 2D array
arr2 = np.array([[1,2,3], [4,5,6]])
print(arr2[1, 1:4])