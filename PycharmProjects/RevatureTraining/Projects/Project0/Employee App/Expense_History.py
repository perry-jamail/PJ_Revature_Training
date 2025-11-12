# Script for handling the view expense history requirement.
# TODO: (Optional) Create functionality to allow the admin user to view all expenses for all users and to lookup expenses
#  by specific usernames

import json

# TODO: Make a better view of the expenses using pandas, and make the user acknowledge the list before moving back to options
def view_expenses_by_username(username):
    with open('expenses.json', 'r') as file:
        expenses = json.load(file)

    if username in expenses:
        print(expenses[username])
    else:
        print("There are no expenses listed for the logged-in user.")