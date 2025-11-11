"""
Requirements:
* Build a simple personal portfolio with Flask.
* Have pages like Home, Projects, and Contact.
* Load project data from a JSON file.
"""
from flask import Flask, render_template, request
import json
app = Flask(__name__)

@app.route('/')
def home():
    return render_template("home.html")

@app.route('/project')
def project():
    with open('projects.json') as file:
        projects = json.load(file)

    return render_template("project.html", list=projects)

@app.route('/contact')
def contact():
    return render_template("contact.html")

if __name__ == '__main__':
    app.run(debug=True)