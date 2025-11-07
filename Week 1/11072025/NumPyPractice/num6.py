import numpy as np

# Normal concat
arr1 = np.array([1, 2, 3])
arr2 = np.array([4, 5, 6])
arr = np.concatenate((arr1, arr2))
print(arr)

# Multi-dimensional concat
arr3 = np.array([[1, 2], [3, 4]])
arr4 = np.array([[5, 6], [7, 8]])
arr = np.concatenate((arr3, arr4), axis=1)
print(arr)