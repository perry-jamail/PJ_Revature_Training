import logging

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

def edit_pending_expense(username, connection):
    cursor = connection.cursor()

    cursor.execute(f"select employee_id from employees where username = '{username}'")
    employeeId = int(cursor.fetchone()[0])
    cursor.execute(f"select expense_id from expenses where employee_id = {employeeId} and status = 'Pending'")
    pending_expenses = cursor.fetchall()

    if len(pending_expenses) > 0:
        pending_expenses_list = [expense[0] for expense in pending_expenses]
    else:
        print(f"\nThere are no Pending expenses listed for '{username}'.\n")
        cursor.close()
        return None

    print("\n%% Edit Pending Expense %%")

    expense_id = input("Enter the ID of the Pending expense to edit: ")
    while not validate_int_number(expense_id):
        logging.error(f"'{username}' has entered an invalid ID when editing a pending expense.")
        expense_id = input("ID must be a valid number. Please enter a valid ID: ")

    if int(expense_id) in pending_expenses_list:
        amountValid = False
        updated_expense = {
            "name": input("New Title: "),
            "amount": input("New Amount: "),
            "category": input("New Category: "),
            "description": input("New Description: ")
        }

        while not amountValid:
            if validate_float_number(updated_expense["amount"]):
                if 0 < float(updated_expense["amount"]) < 100000000.00:
                    amountValid = True
                else:
                    logging.error(f"'{username}' has entered an invalid amount when editing a pending expense.")
                    updated_expense["amount"] = input("Amount must be between 0 and 100 million. Please enter a valid amount: ")
            else:
                logging.error(f"'{username}' has entered an invalid amount when editing a pending expense.")
                updated_expense["amount"] = input("Amount must be a valid number. Please enter a valid amount: ")

        while len(updated_expense["description"]) < 10:
            logging.error(f"'{username}' has entered too short of a description when editing a pending expense.")
            updated_expense["description"] = input(
                "\nDescription must be longer than 10 characters. Please enter a valid description: ")

        cursor.execute(f"update expenses set name = '{updated_expense["name"]}',"
                       f"amount = '{updated_expense["amount"]}', category = '{updated_expense["category"]}',"
                       f"description = '{updated_expense["description"]}' where expense_id = {int(expense_id)}")
        connection.commit()

        print(f"\n'{updated_expense["name"]}' was successfully updated.\n")
        logging.info(f"'{username}' edited pending expense '{updated_expense["name"]}'.")
        cursor.close()
        return None
    else:
        logging.warning(f"'{username}' has entered an invalid ID when editing a pending expense.")
        print(f"There are no Pending expenses with the ID of '{expense_id}' under the user '{username}'.\n")
        cursor.close()
        return None

def validate_float_number(input_str):
    try:
        float(input_str)
        return True
    except ValueError:
        return False

def validate_int_number(input_str):
    try:
        int(input_str)
        return True
    except ValueError:
        return False