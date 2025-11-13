def isAnagram(word1, word2):
    word1 = list(word1.lower())
    word2 = list(word2.lower())

    print(word1)
    print(word2)

    word1.sort()
    word2.sort()

    print(f"After sort = {word1}")
    print(f"After sort = {word2}")

    if word1 == word2:
        print(True)
    else:
        print(False)

isAnagram("Listen", "Silent")

