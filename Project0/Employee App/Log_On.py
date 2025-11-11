# Script for handling the employee sign-in and authentication processes
import json


def login():
    credentials = openJSON()
    access = False
    while not access:
        username = input('Enter your username: ')

        if username in credentials:
            password = input('Enter your password: ')
            if credentials[username] == password:
                print(f"Authentication Successful. Logged in as {username}.")
                return True
            else:
                print('Username exists, but the password is incorrect.\n')
        else:
            print('Username not found.\n')

# CRUD operation methods below

def addCred():
    username = input('Enter your new account\'s username: ')
    password = input('Enter your new account\'s password: ')

    credentials = openJSON()
    if username not in credentials:
        credentials[username] = password
        saveCred(credentials)
        print(f"Account with the username '{username}' was successfully created.")
    else:
        print("Username already exists.")

def removeCred():
    username = input('Enter the username of the account to remove: ')

    if checkCred(username):
        credentials = openJSON()
        credentials.pop(username)
        saveCred(credentials)
        print(f"Account with the username '{username}' was successfully removed.")

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

def updatePassword():
    username = input('Enter the current username of the account to update: ')

    if checkCred(username):
        credentials = openJSON()
        newPW = input('Enter new password: ')
        credentials[username] = newPW
        saveCred(credentials)
        print(f"The password associated with the account with the username "
              f"'{username}' was successfully updated.")

# Utility methods below

def checkCred(username):
    credentials = openJSON()

    if username in credentials:
        pswd = input(f'Enter the password associated with the account {username}: ')
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