# Define two lists. The first one contains name, 3 or 4. The second list contains ages. Combine those two lists in tuples.

names = ["Alice", "Bob", "Charlie"]
ages = [30, 24, 35, 50]

combined_data = zip(names, ages)
print(list(combined_data))

'''
The zip() function in Python is a built-in utility that combines multiple iterable objects into a single iterable of tuples.
It pairs corresponding elements from each input iterable based on their index.

Unzipping is the opposite of this process. There is no built-in function for this functionality in Python.

EX:
zipped = [('Alice', 30), ('Bob', 24)]
unzipped_names, unzipped_ages = zip(*zipped)
print(unzipped_names)
print(unzipped_ages)
'''