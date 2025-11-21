# Script for handling the expense submission requirement.
import json, logging
from datetime import date

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')


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
        "description": input("Description: ")
    }

    # validations
    while float(newExpense["amount"]) < 0:
        logging.error(f"'{username}' has entered a negative amount when creating a new expense.")
        newExpense["amount"] = input("Amount cannot be less than 0. Please enter a valid amount: ")

    while len(newExpense["description"]) < 10:
        logging.error(f"'{username}' has entered too short of a description when creating a new expense.")
        newExpense["description"] = input("Description must be longer than 10 characters. Please enter a valid description: ")

    with open('NextID.txt', 'w') as file:
        file.write(str(nextId + 1))

    userExpenses[newExpenseName] = newExpense
    expenseList[username] = userExpenses

    print(f"\n'{newExpenseName}' was successfully added.\n")
    logging.info(f"'{username}' added expense '{newExpenseName}'.")

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
        "description": input("Description: ")
    }

    # validations
    while float(newExpense["amount"]) < 0:
        logging.error(f"'{username}' has entered a negative amount when creating a new expense.")
        newExpense["amount"] = input("Amount cannot be less than 0. Please enter a valid amount: ")

    while len(newExpense["description"]) < 10:
        logging.error(f"'{username}' has entered too short of a description when creating a new expense.")
        newExpense["description"] = input(
            "Description must be longer than 10 characters. Please enter a valid description: ")

    with open('NextID.txt', 'w') as file:
        file.write(str(nextId + 1))

    userExpenses = {newExpenseName: newExpense}
    expenseList[username] = userExpenses

    print(f"\n'{newExpenseName}' was successfully added.\n")
    logging.info(f"'{username}' added expense '{newExpenseName}'.")

    with open('expenses.json', 'w') as file:
        json.dump(expenseList, file, indent=4)