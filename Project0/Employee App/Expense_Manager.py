# CLI Application 'home' page.
# Should serve as a "main" or "home" page for the app, options include view expense history,
# submit new expenses, view status of submitted expenses (appending, approved, denied), edit expenses, and delete expenses.
import Log_On as lg
import Expense_History as his
import sys

logged_in = False
username = ''
def welcome():
    global logged_in, username
    login_or_create = input("Welcome to the Employee Expense Manager Application! Please enter (1) to login"
                            " or (2) to create an account! ")
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
                   " Status of Submitted Expenses\n\t4) Edit Expense\n\t5) Delete Expense\n\tq) Quit Application\n> ")

        if op == '1':
            his.view_expenses_by_username(username)
        elif op == '2':
            # TODO: Write functionality to handle submitting a new expense
            pass
        elif op == '3':
            # TODO: Write functionality to handle viewing the status of submitted expenses
            pass
        elif op == '4':
            # TODO: Write functionality to handle editing expenses
            pass
        elif op == '5':
            # TODO: Write functionality to handle deleting expenses
            pass
        elif op == 'q':
            print("Quitting application...")
            sys.exit()
        else:
            print("Please enter a valid input.\n")

welcome()