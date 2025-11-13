# Script for handling the expense submission requirement.
import json
from datetime import date


def add_expense_by_username(username):
    with open('expenses.json', 'r') as file:
        expenses = json.load(file)

    if  username in expenses:
        add_to_existing_list(username, expenses)
    else:
        create_new_list_entry(username, expenses)

def add_to_existing_list(username, expenseList):
    with open('NextID.txt', 'r') as file:
        nextId = int(file.read())

    userExpenses = expenseList[username]
    expenseList.pop(username)

    newExpenseName = input("\nPlease enter the new expense title: ")
    newExpense = {
        "id": str(nextId),
        "date": str(date.today()),
        "amount": input("Amount: "),
        "category": input("Category: "),
        "status": "Pending",
        "description": input("Description (optional): ")
    }
    print()
    with open('NextID.txt', 'w') as file:
        file.write(str(nextId + 1))

    userExpenses[newExpenseName] = newExpense
    expenseList[username] = userExpenses

    with open('expenses.json', 'w') as file:
        json.dump(expenseList, file, indent=4)

def create_new_list_entry(username, expenseList):
    with open('NextID.txt', 'r') as file:
        nextId = int(file.read())

    newExpenseName = input("\nPlease enter the new expense title: ")
    newExpense = {
        "id": str(nextId),
        "date": str(date.today()),
        "amount": input("Amount: "),
        "category": input("Category: "),
        "status": "Pending",
        "description": input("Description (optional): ")
    }
    print()
    with open('NextID.txt', 'w') as file:
        file.write(str(nextId + 1))

    userExpenses = {newExpenseName: newExpense}
    expenseList[username] = userExpenses

    with open('expenses.json', 'w') as file:
        json.dump(expenseList, file, indent=4)