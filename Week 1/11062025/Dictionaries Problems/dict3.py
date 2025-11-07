employees = {
    'Harper': {
        'name': 'Harper',
        'age': 26,
        'salary': 50000
    },
    'Kenzie': {
        'name': 'Kenzie',
        'age': 24,
        'salary': 70000
    },
    'Amara': {
        'name': 'Amara',
        'age': 31,
        'salary': 28000},
    'Emma': {
        'name': 'Emma',
        'age': 22,
        'salary': 46000
    },
    'Ethan': {
        'name': 'Ethan',
        'age': 23,
        'salary': 40000
    }
}

def giveRaise(dictionary):
    for d in dictionary:
        dictionary[d]['salary'] += dictionary[d]['salary'] * .10

giveRaise(employees)
print(employees)