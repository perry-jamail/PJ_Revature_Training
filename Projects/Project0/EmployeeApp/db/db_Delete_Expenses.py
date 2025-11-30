import logging

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

def delete_pending_expense(username, connection):
    cursor = connection.cursor()

    cursor.execute(f"select employee_id from employees where username = '{username}'")
    employeeId = int(cursor.fetchone()[0])
    cursor.execute(f"select expense_id from expenses where employee_id = {employeeId} and status = 'Pending'")
    pending_expenses = cursor.fetchall()

    if len(pending_expenses) > 0:
        pending_expenses_list = [expense[0] for expense in pending_expenses]
    else:
        print(f"\nThere are no Approved or Denied expenses listed for '{username}'.\n")
        cursor.close()
        return None

    print("\n%% Delete Pending Expense %%")

    expense_id = input("Enter the ID of the Pending expense to delete: ")
    while not validate_int_number(expense_id):
        logging.error(f"'{username}' has entered an invalid ID when deleting an expense.")
        expense_id = input("ID must be a valid number. Please enter a valid ID: ")

    if int(expense_id) in pending_expenses_list:
        cursor.execute(f"select name from expenses where expense_id = {expense_id}")
        expense_name = cursor.fetchone()[0]

        cursor.execute(f"delete from expenses where expense_id = {int(expense_id)}")
        connection.commit()

        print(f"\n'{expense_name}' was successfully deleted.\n")
        logging.info(f"'{username}' deleted pending expense '{expense_name}'.")
        cursor.close()
        return None
    else:
        logging.warning(f"'{username}' has entered an invalid ID when deleting a pending expense.")
        print(f"There are no Pending expenses with the ID of '{expense_id}' under the user '{username}'.\n")
        cursor.close()
        return None

def validate_int_number(input_str):
    try:
        int(input_str)
        return True
    except ValueError:
        return False