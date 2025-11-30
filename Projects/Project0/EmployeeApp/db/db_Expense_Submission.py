from datetime import date
import logging, math

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

def add_expense(username, connection):
    cursor = connection.cursor()

    cursor.execute(f"select employee_id from employees where username = '{username}'")
    employeeId = int(cursor.fetchone()[0])

    print("\n%% New Expense Submission %%")

    amountValid = False
    newExpense = {
        "name": input("Title: "),
        "amount": input("Amount: "),
        "category": input("Category: "),
        "description": input("Description: ")
    }

    while not amountValid:
        if validate_number(newExpense["amount"]):
            if float(newExpense["amount"]) > 0:
                amountValid = True
            else:
                logging.error(f"'{username}' has entered a negative amount when creating a new expense.")
                newExpense["amount"] = input("Amount cannot be less than 0. Please enter a valid amount: ")
        else:
            logging.error(f"'{username}' has entered an invalid amount when creating a new expense.")
            newExpense["amount"] = input("Amount must be a valid number. Please enter a valid amount: ")

    while len(newExpense["description"]) < 10:
        logging.error(f"'{username}' has entered too short of a description when creating a new expense.")
        newExpense["description"] = input(
            "\nDescription must be longer than 10 characters. Please enter a valid description: ")

    cursor.execute(
        f"insert into expenses(employee_id, name, submission_date, amount, category, status, description)"
        f" values ({employeeId}, '{newExpense["name"]}', '{date.today()}', '{float(newExpense["amount"])}', "
        f"'{newExpense["category"]}', 'Pending', '{newExpense["description"]}')")
    connection.commit()

    print(f"\n'{newExpense["name"]}' was successfully added.\n")
    logging.info(f"'{username}' added expense '{newExpense["name"]}'.")

    cursor.close()

def validate_number(input_str):
    try:
        int(input_str)
        return True
    except ValueError:
        return False