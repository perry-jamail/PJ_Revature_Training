# Script for handling the view expense history requirement.
import json, logging
import pandas as pd
from tabulate import tabulate

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

def view_expenses_by_username(username):
    pd.set_option('display.max_columns', None)

    with open('expenses.json', 'r') as file:
        expenses = json.load(file)

    if username in expenses:
        df = pd.DataFrame.from_dict(expenses[username])
        print(f"\n{tabulate(df, headers="keys", tablefmt="psql")}\n")
        logging.info(f"'{username}' viewed all expenses associated with this account.")
    else:
        print("There are no expenses listed for the logged-in user.\n")