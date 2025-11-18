# Script for handling the employee sign-in and authentication processes
# TODO: (Optional) Create logoff functionality
import json, sys, logging

logging.basicConfig(filename="employeeApp.log",
                    level=logging.INFO,
                    filemode='a',
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')


def login():
    credentials = openJSON()
    username = ''
    while username != 'q':
        print("\n%% Login ('q' to quit) %%")
        username = input('Enter your username: ')
        if username in credentials:
            password = input('Enter your password: ')
            if credentials[username] == password:
                print(f"Authentication Successful. Logged in as '{username}'.\n")
                logging.info(f"'{username}' logged in.")
                return True, username
            else:
                print('Username exists, but the password is incorrect.\n')
                logging.warning(f"Unsuccessful login attempt for account '{username}'.")
        elif username != 'q':
            print('Username not found.\n')
    if username == 'q':
        print("Quitting application...")
        logging.info("Application quit.")
        sys.exit()

# CRUD operation methods below

def addCred():
    print("\n%% New Account Creation ('q' to quit) %%")
    username = input('Enter your new account\'s username: ')

    credentials = openJSON()
    if username not in credentials and username != 'q':
        password = input('Enter your new account\'s password: ')
        credentials[username] = password
        saveCred(credentials)
        print(f"Account with the username '{username}' was successfully created.\n")
        logging.info(f"Account created with username '{username}'.")
    elif username == 'q':
        print("Quitting application...")
        logging.info("Application quit.")
        sys.exit()
    else:
        print("Username already exists.\n")
        logging.warning(f"Duplicate account creation attempted for '{username}'.")

def removeCred():
    username = input('Enter the username of the account to remove: ')

    if checkCred(username):
        credentials = openJSON()
        credentials.pop(username)
        saveCred(credentials)
        print(f"Account with the username '{username}' was successfully removed.")
        logging.warning(f"Account with username '{username}' was removed.")

def updateUsername():
    username = input('Enter the current username of the account to update: ')

    if checkCred(username):
        credentials = openJSON()
        savedP = credentials[username]
        credentials.pop(username)
        newUsername = input('Enter new username: ')
        credentials[newUsername] = savedP
        saveCred(credentials)
        print(f"Account with the username '{username}' was successfully "
              f"updated with the new username of '{newUsername}'.")
        logging.info(f"Account with username '{username}' changed username to '{newUsername}'.")

def updatePassword():
    username = input('Enter the current username of the account to update: ')

    if checkCred(username):
        credentials = openJSON()
        newPW = input('Enter new password: ')
        credentials[username] = newPW
        saveCred(credentials)
        print(f"The password associated with the account with the username "
              f"'{username}' was successfully updated.")
        logging.info(f"Account with username '{username}' changed passwords.")

# Utility methods below

def checkCred(username):
    credentials = openJSON()

    if username in credentials:
        pswd = input(f"Enter the password associated with the account '{username}': ")
        if credentials[username] == pswd:
            return True
        else:
            print("Incorrect password.")
            return False
    else:
        print("Username not found.")
        return False

def openJSON():
    with open('credentials.json', 'r') as file:
        credentials = json.load(file)
    return credentials

def saveCred(d):
    with open('credentials.json', 'w') as file:
        json.dump(d, file, indent=4)