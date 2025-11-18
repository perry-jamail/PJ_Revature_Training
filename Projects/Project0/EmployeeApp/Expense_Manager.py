# CLI Application 'home' page.
# Should serve as a "main" or "home" page for the app, options include view expense history,
# submit new expenses, view status of submitted expenses (appending, approved, denied), edit expenses, and delete expenses.
import Log_On as lg
import Expense_History as his
import Expense_Submission as sub
import Approved_Denied_Expenses as ade
import Edit_Expenses as ee
import Delete_Expenses as de
import sys, logging

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

logged_in = False
username = ''
def welcome():
    global logged_in, username
    login_or_create = input("Welcome to the Employee Expense Manager Application! Please enter (1) to login"
                            " or (2) to create an account! >")
    if login_or_create == "1":
        logged_in, username = lg.login()
        if logged_in:
            application()
    elif login_or_create == "2":
        lg.addCred()
        logged_in, username = lg.login()
        if logged_in:
            application()
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
            his.view_expenses_by_username(username)
        elif op == '2':
            sub.add_expense_by_username(username)
        elif op == '3':
            ade.view_approved_denied_by_username(username)
        elif op == '4':
            ee.edit_pending_expense_by_username(username)
        elif op == '5':
            de.delete_pending_expense_by_username(username)
        elif op == 'q':
            print("Quitting application...")
            logging.info("Application quit.")
            sys.exit()
        else:
            print("Please enter a valid input.\n")

welcome()