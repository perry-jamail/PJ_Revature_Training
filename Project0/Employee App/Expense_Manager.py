# CLI Application 'home' page.
import Log_On as lg

logged_in = False
def welcome():
    global logged_in
    login_or_create = input("Welcome to the Employee Expense Manager Application! Please enter (1) to login"
                            " or (2) to create an account! ")
    if login_or_create == "1":
        logged_in = lg.login()
    elif login_or_create == "2":
        lg.addCred()
        logged_in = lg.login()
    else:
        print("Please enter either 1 or 2\n")
        welcome()

welcome()