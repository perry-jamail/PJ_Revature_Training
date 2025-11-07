dict1 = {
    'name': 'Harper',
    'age': 5,
    'city': 'Plano',
    'gender': 'Female'
}

def dictIterator(d):
    for k, v in d.items():
        print(f"{k} : {v}")

dictIterator(dict1)