# Script for handling the employee sign-in and authentication processes
import sys, logging

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

def login(connection):
    cursor = connection.cursor()

    username = ''
    while username != 'q':
        print("\n%% Login ('q' to quit) %%")
        username = input('Enter your username: ')
        if username != 'q':
            cursor.execute(f"select password from employees where username = '{username}'")

            try:
                stored_password = cursor.fetchone()[0]
            except TypeError:
                print('Username not found.')
            else:
                password = input('Enter your password: ')
                if stored_password == password:
                    print(f"Authentication Successful. Logged in as '{username}'.\n")
                    logging.info(f"'{username}' logged in.")
                    cursor.close()
                    return True, username
                else:
                    print('Username exists, but the password is incorrect.')
                    logging.warning(f"Unsuccessful login attempt for account '{username}'.")


    print("Quitting application...")
    logging.info("Application quit.")
    cursor.close()
    connection.close()
    sys.exit()

# CRUD operation methods below

def addCred(connection):
    cursor = connection.cursor()
    print("\n%% New Account Creation ('q' to quit) %%")
    username = input('Enter your new account\'s username: ')
    cursor.execute(f"select password from employees where username = '{username}'")

    if username != 'q':
        try:
            stored_password = cursor.fetchone()[0]
        except TypeError:
            password = input('Enter your new account\'s password: ')
            cursor.execute(f"insert into employees (username, password) values('{username}', '{password}')")
            connection.commit()
            print(f"Account with the username '{username}' was successfully created.\n")
            logging.info(f"Account created with username '{username}'.")
            cursor.close()
        else:
            print("Username already exists.\n")
            logging.warning(f"Duplicate account creation attempted for '{username}'.")
            cursor.close()
    else:
        print("Quitting application...")
        logging.info("Application quit.")
        cursor.close()
        connection.close()
        sys.exit()