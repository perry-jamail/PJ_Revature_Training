# Given a list with numbers 1-10, calculate and display the sum of numbers in the list.
from functools import reduce

numbers = [1,2,3,4,5,6,7,8,9,10]
summedNums = reduce(lambda x,y: x+y, numbers)
print(summedNums)

'''
Reduce applies a function of two arguments cumulatively to the items of an iterable from left to right,
reducing the iterable to a single value. It requires importing from the functools module.
'''