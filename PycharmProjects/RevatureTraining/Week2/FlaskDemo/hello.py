from flask import Flask, redirect, url_for
import math

app = Flask(__name__)


@app.route('/')
def hello_world():
    return "Hello World!"

@app.route('/hello')
def hello_again():
    return "Hello World Again!"

@app.route('/hello/<name>')
def hiname(name):
    return 'Hi, %s!' % name

@app.route('/squared/<int:num>')
def square(num):
    return str(num * num)

# Calculate the area of a circle with a radius of 5.5
@app.route('/circle_area/<float:num>')
def circle_area(num):
    return str((num * num) * math.pi)

# Display the sum of two numbers
@app.route('/sum/<int:num1>/<int:num2>')
def sumnums(num1, num2):
    return str(num1 + num2)

# url_for is used for dynamically building a URL for a specific function
@app.route('/hello_user/<username>')
def hello_user(username):
    if username == 'admin':
        return redirect(url_for('hello_admin', admin=username))
    else:
        return redirect(url_for('hello_guest', guest=username))

# This is the method that redirect(url_for()) for admin within hello_user is pointing at
@app.route('/admin/<admin>')
def hello_admin(admin):
    return "Hello Admin! %s" % admin

# This is the method that redirect(ur_for()) for guests within hello_user is pointing at
@app.route('/guest/<guest>')
def hello_guest(guest):
    return "Hello Guest! %s" % guest

# Demonstrating a different way of setting an endpoint using add_url_rule()
def hithere():
    return 'hi there'

app.add_url_rule('/hi', view_func=hithere)

if __name__ == '__main__':
# Starts the server. Runs on code 5000
    app.run(debug=True)