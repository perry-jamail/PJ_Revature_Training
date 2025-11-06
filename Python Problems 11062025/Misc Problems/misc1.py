# Create a list of 5 numbers. Calculate and print the squares.

def calcSquares(nums):
    for i in range(len(nums)):
        nums[i] = nums[i]**2
    print(nums)

calcSquares([1,2,3,4,5])

'''
map function is a way to apply a given function to each item in an iterable and returns a map object,
which is an iterator containing the results.

EX:
numbers = [1,2,3,4]
squared_numbers = list(map(lambda x: x**2, numbers))
print(squared_numbers)

output: [1, 4, 9, 16]
'''