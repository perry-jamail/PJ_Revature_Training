from flask import Flask, render_template, request
import json
app = Flask(__name__)

@app.route('/')
def home_screen():
    return render_template("home.html")

@app.route('/view')
def view_todo_list():
    with open('toDoList.json', 'r') as file:
        currJsonList = json.load(file)

    return render_template("view.html", list = currJsonList)

@app.route('/add')
def add_todo():
    return render_template("add.html")

@app.route('/add_item', methods=['POST'])
def add_item():
    itemName = request.form['it']
    itemStatus = request.form['st']

    with open('toDoList.json', 'r') as file:
        currJsonList = json.load(file)

    currJsonList[itemName] = itemStatus
    save_list(currJsonList)

    return render_template("add_item.html", IN=itemName, IS=itemStatus)

@app.route('/update')
def update_todo():
    return render_template("update.html")

@app.route('/update_item', methods=['POST'])
def update_item():
    itemName = request.form['it']
    itemStatus = request.form['st']
    with open('toDoList.json', 'r') as file:
        currJsonList = json.load(file)

    if itemName in currJsonList:
        currJsonList[itemName] = itemStatus
        save_list(currJsonList)

        return render_template("update_item.html", IN=itemName, IS=itemStatus)
    else:
        return render_template("not_found.html")

@app.route('/delete')
def delete_todo():
    return render_template("delete.html")

@app.route('/delete_item', methods=['POST'])
def delete_item():
    itemName = request.form['it']
    with open('toDoList.json', 'r') as file:
        currJsonList = json.load(file)

    if itemName in currJsonList:
        itemStatus = currJsonList[itemName]

        currJsonList.pop(itemName)
        save_list(currJsonList)

        return render_template("delete_item.html", IN=itemName, IS=itemStatus)
    else:
        return render_template("not_found.html")

def save_list(d):
    with open('toDoList.json', 'w') as file:
        json.dump(d, file, indent=4)

if __name__ == '__main__':
    app.run(debug=True)