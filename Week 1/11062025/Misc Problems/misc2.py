# create a list 1-10. From that list create a list containing only even numbers.

numbers = [1,2,3,4,5,6,7,8,9,10]
evenNumbers = list(filter(lambda x: x % 2 == 0, numbers))
print(evenNumbers)

'''
Filter constructs an interator from elements of an iterable for which the given function returns True. The function
must return a boolean value.
'''