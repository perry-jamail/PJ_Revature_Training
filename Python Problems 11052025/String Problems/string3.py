# Given a string s, and a pattern p. You need to find if p exists in s or not and return the starting index of p in s.
# If p does not exist in s then -1 will be returned.
# Here p and s both are case-sensitive.

def patternLocator(s, p):
    if p in s:
        return s.index(p)
    else:
        return -1

print(patternLocator("hello world", "world"))
print(patternLocator("hello world", "Hello"))