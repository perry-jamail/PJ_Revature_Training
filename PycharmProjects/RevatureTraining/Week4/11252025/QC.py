# Get a string from a user, remove all punctuation from that string
def removePunc():
    s = input("Please enter a string: ")
    newS = ""
    for c in s:
        if c == "." or c == "," or c == "?" or c == "!":
            continue
        else:
            newS += c

    print(newS)

removePunc()