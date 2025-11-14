# Script for handling the viewing of expense statuses requirement.
import json
import pandas as pd

def view_approved_denied_by_username(username):
    with open('expenses.json', 'r') as file:
        expenses = json.load(file)

    if username in expenses:
        returnDict = {}
        user_expenses = expenses[username]

        for outer_key, inner_dict in user_expenses.items():
            for inner_key, inner_value in inner_dict.items():
                if inner_key == "status":
                    if inner_value == "Approved" or inner_value == "Denied":
                        returnDict[outer_key] = inner_dict

        if returnDict:
            print(f"\n{pd.DataFrame.from_dict(returnDict)}\n")
        else:
            print(f"\nUser '{username}' has no Approved or Denied expenses.\n")
    else:
        print("There are no expenses listed for the logged-in user.\n")