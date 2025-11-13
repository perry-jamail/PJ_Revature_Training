# Script for handling the view expense history requirement.

import json
import pandas as pd

def view_expenses_by_username(username):
    with open('expenses.json', 'r') as file:
        expenses = json.load(file)

    if username in expenses:
        print(f"\n{pd.DataFrame.from_dict(expenses[username])}\n")
    else:
        print("There are no expenses listed for the logged-in user.\n")