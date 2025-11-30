# CLI Application 'home' page.
# Should serve as a "main" or "home" page for the app, options include view expense history,
# submit new expenses, view status of submitted expenses (appending, approved, denied), edit expenses, and delete expenses.
import db_Login as lg
import db_Expense_History as his
import db_Expense_Submission as es
import db_Approved_Denied_Expenses as ade
import db_Edit_Expenses as ee
import db_Delete_Expenses as de

import sys, logging
from mysql.connector import (connection)

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

connection = connection.MySQLConnection(user='root', password='admin', host='localhost', database='ExpenseManager')

logged_in = False
username = ''
def welcome():
    global logged_in, username
    login_or_create = input("Welcome to the Employee Expense Manager Application! Please enter (1) to login"
                            " or (2) to create an account! ('q' to quit) > ")
    if login_or_create == "1":
        logged_in, username = lg.login(connection)
        if logged_in:
            application()
    elif login_or_create == "2":
        lg.addCred(connection)
        welcome()
    elif login_or_create.lower() == "q":
        print("Quitting application...")
        logging.info("Application quit.")
        sys.exit()
    else:
        print("Please enter either 1 or 2\n")
        welcome()

def application():
    global logged_in, username
    # Serves as the options screen
    op = ''
    while op != 'q':
        op = input("Please enter a function to perform:\n\t1) View Expense History\n\t2) Submit a New Expense\n\t3) View"
                   " History of Approved and Denied Expenses\n\t4) Edit Pending Expense\n\t5) Delete Pending Expense\n\tq) Quit Application\n> ")

        if op == '1':
            his.view_expenses_by_username(username, connection)
        elif op == '2':
            es.add_expense(username, connection)
        elif op == '3':
            ade.view_approved_denied_by_username(username, connection)
        elif op == '4':
            ee.edit_pending_expense(username, connection)
        elif op == '5':
            de.delete_pending_expense(username, connection)
            pass
        elif op == 'q':
            print("Quitting application...")
            logging.info("Application quit.")
            connection.close()
            sys.exit()
        else:
            print("Please enter a valid input.\n")

welcome()