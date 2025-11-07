# Using nditer to iterate through an array

import numpy as np

arr = np.array([[[1, 2], [3, 4]], [[5, 6], [7, 8]]])
for x in np.nditer(arr):
  print(x)

# Skipping 1 element
arr2 = np.array([[1, 2, 3, 4], [5, 6, 7, 8]])
for x in np.nditer(arr2[:, ::2]):
  print(x)