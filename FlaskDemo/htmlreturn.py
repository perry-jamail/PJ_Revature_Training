from flask import Flask, render_template

# Adding the template_folder parameter you can change where the templates are.
# Default is a folder named templates
app = Flask(__name__, template_folder='views')


@app.route('/index')
def index():
    return render_template('hello2.html')


if __name__ == '__main__':
    app.run(debug=True)