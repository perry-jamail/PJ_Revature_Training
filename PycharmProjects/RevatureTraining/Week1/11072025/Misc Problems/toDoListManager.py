# To-Do List Manager: Create a program to add, view, mark as complete, and delete tasks from a list/dictionary,
# potentially saving the list/dictionary to a file.

# Please use the following as well while writing code
# 1. Functions
# 2. Modules (Optional)
# 3. Imports (Optional)

import json
import sys

toDoList = {}

def listManager():
    while True:
        op = input("\nPlease enter what operation you would like to perform on the list (add, view, mark as complete, "
                   "save list, or delete). Press 'q' to quit: ")
        if op == "add":
            addTask()
        elif op == "view":
            viewTask()
        elif op == "mark as complete":
            markTask()
        elif op == "delete":
            deleteTask()
        elif op == "save list":
            saveList(toDoList)
        elif op == "q":
            sys.exit()
        else:
            print("You have not entered a valid command, please type \"add\", \"view\", \"mark as complete\", \"save list\","
                  " \"delete\", or 'q'.")

# Adds a task to the toDoList dictionary and prints that task and its status
def addTask():
    newTask = input("\nPlease enter the task name: ")
    newStatus = input("Please enter the task status (pending, in progress, completed): ")

    toDoList[newTask] = newStatus
    print(f"\n\"{newTask}\" has been added to the unsaved list with status \"{newStatus}\". \nThe full unsaved list is now:\n{toDoList}")

# Prints the specified task and its status
def viewTask():
    with open('toDoList.json', 'r') as file:
        currJsonList = json.load(file)

    taskToView = input("Please enter the name of the task you would like to view (enter * for all tasks in the saved list): ")
    if taskToView == "*":
        print(currJsonList)
    elif taskToView in currJsonList:
        print(f"{taskToView}: {currJsonList[taskToView]}")
    else:
        print("Specified task does not exist.")

# Updates status of task and prints the task with its new status
def markTask():
    with open('toDoList.json', 'r') as file:
        currJsonList = json.load(file)

    taskToMark = input("Please enter the name of the task you would like to mark as completed: ")
    if taskToMark in currJsonList:
        currJsonList[taskToMark] = "completed"
        saveList(currJsonList)

        print(f"The {taskToMark} task has been marked as complete on the saved list. The change has been saved and the unsaved list is now empty.")
    else:
        print("Specified task does not exist.")

# Removes the specified task from the toDoList dictionary and prints the deleted task and its status
def deleteTask():
    with open('toDoList.json', 'r') as file:
        currJsonList = json.load(file)

    taskToDel = input("Please enter the name of the task you would like to delete: ")
    if taskToDel in currJsonList:
        currJsonList.pop(taskToDel)
        saveList(currJsonList)

        print(f"The {taskToDel} task has been deleted from the saved list. The change has been saved and the unsaved list is now empty.")
    else:
        print("Specified task does not exist.")

def saveList(d):
    with open('toDoList.json', 'w') as file:
        json.dump(d, file, indent=4)

listManager()