# You are given a number k and a list arr[] that contains integers. You need to return list of numbers that are less than k.
# Example
# Input: arr[] = [54, 43, 2, 1, 5], k = 6
# Output: 2 1 5
# Explanation: 2 1 5 are less than 6.

def lessThan(k, arr):
    returnList = []
    for i in arr:
        if i < k:
            returnList.append(i)

    return returnList

print(lessThan(6, [54, 43, 2, 1, 5]))