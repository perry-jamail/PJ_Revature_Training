'''
Requirements:
* Add, view, and delete expenses with date, category, and amount.
* Store data in a CSV or SQLite database.
* Calculate total and category-wise summaries.

Required Features:
Implement all of the following to call the project complete:

Add an expense with fields:
* id (unique)
* date (ISO YYYY-MM-DD)
* amount (float)
* category (string)
* description (string, optional)
* list/view all expenses (paginated or limited view for CLI)
* Delete an expense by id.
* Edit/update an expense by id.

## expenses = {
    groceries1: {id: number, date: XXXX-XX-XX, amount: number, category: string, description: string},
    gas1: {id: number, date: XXXX-XX-XX, amount: number, category: string, description: string}
} ##

Persist data in:
* a CSV file (expenses.csv)

Show summary statistics:
* Total expenses (all time)
* Total by category
* Total for a date range

Include basic input validation and error handling
'''