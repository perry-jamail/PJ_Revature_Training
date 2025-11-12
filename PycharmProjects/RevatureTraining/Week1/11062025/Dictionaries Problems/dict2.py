students = {
    'John': 85,
    'Jim': 78,
    'Terry': 90,
    'Ally': 89,
    'Sarah': 67
}

def highestScore(dictionary):
    highScore = 0
    student = ''
    for key, value in dictionary.items():
        if value > highScore:
            highScore = value
            student = key

    print(f"The student with the highest score is {student} with a grade of {highScore}.")

highestScore(students)