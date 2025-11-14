# Script for handling the delete expenses requirement
import json

def delete_pending_expense_by_username(username):
    with open('expenses.json', 'r') as file:
        expenses = json.load(file)

    find_list_of_pending_expenses(username, expenses)

def find_list_of_pending_expenses(username, expenses):
    if username in expenses:
        pending_expenses = {}
        user_expenses = expenses[username]

        for outer_key, inner_dict in user_expenses.items():
            for inner_key, inner_value in inner_dict.items():
                if inner_key == "status":
                    if inner_value == "Pending":
                        pending_expenses[outer_key] = inner_dict

        exp_id = input("\nEnter the ID of the expense to delete: ")
        find_pending_expense_by_id(exp_id, pending_expenses, username, expenses)
    else:
        print(f"There are no pending expenses for {username}.\n")

def find_pending_expense_by_id(expense_id, pending_expenses, username, expenses):
    expense = {}

    for outer_key, inner_dict in pending_expenses.items():
        for inner_key, inner_value in inner_dict.items():
            if inner_key == "id":
                if inner_value == expense_id:
                    expense[outer_key] = inner_dict

    if expense != {}:
        JSON_Functions(username, expenses, expense)
    else:
        print(f"There are no pending expenses with the ID of {expense_id}.\n")

def JSON_Functions(username, full_expense_list, expense):
    expense_keys = list(expense.keys())
    expense_name = expense_keys[0]

    userList = full_expense_list[username]
    full_expense_list.pop(username)

    userList.pop(expense_name)
    full_expense_list[username] = userList

    with open('expenses.json', 'w') as file:
        json.dump(full_expense_list, file, indent=4)

    print(f"{expense_name} has been deleted.\n")