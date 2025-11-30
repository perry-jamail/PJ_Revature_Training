# Script for handling the view expense history requirement.
import logging
import pandas as pd
from tabulate import tabulate

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

def view_expenses_by_username(username, connection):
    cursor = connection.cursor()
    pd.set_option('display.max_columns', None)

    cursor.execute(f"select employee_id from employees where username = '{username}'")
    employeeId = int(cursor.fetchone()[0])
    cursor.execute(f"select * from expenses where employee_id = {employeeId}")
    expenses = cursor.fetchall()

    if len(expenses) > 0:
        df = pd.DataFrame(expenses, columns=['expense_id', 'employee_id', 'manager_username', 'name', 'submission_date', 'amount', 'category', 'status', 'description', 'manager_comment'])
        print(f"\n%% All Expenses for '{username}' %%")
        print(f"{tabulate(df, headers="keys", tablefmt="psql")}\n")
        logging.info(f"'{username}' viewed all expenses associated with this account.")
    else:
        print(f"\nThere are no expenses listed for '{username}'.\n")

    cursor.close()