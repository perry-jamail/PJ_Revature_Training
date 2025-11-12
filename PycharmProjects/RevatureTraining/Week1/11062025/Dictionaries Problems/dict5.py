d1 = {
    'name': 'Harper',
    'age': 5
}

d2 = {
    'city': 'Plano',
    'gender': 'Female'
}

def concatDicts(dict1, dict2):
    for k, v in dict2.items():
        dict1[k] = dict2[k]

concatDicts(d1, d2)
print(d1)