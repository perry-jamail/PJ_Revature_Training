'''
Requirements:
* Store questions and answers in a dictionary or JSON file.
* Ask user questions one by one.
* Keep score and show the results at the end.
'''
import json


def quiz():
    with open('questions.json') as f:
        questions_answers = json.load(f)

    correct = 0
    for q, a in questions_answers.items():
        print(q)
        answer = input("Type your answer here: ")
        if answer.lower() == a.lower():
            correct += 1
            print("Correct!\n")
        else:
            print(f"Sorry, that was incorrect. The correct answer is {a}.\n")

    print(f"Thanks for taking the quiz! You got {correct}/5 correct!")

quiz()
