from flask import Flask, request, redirect, url_for

app = Flask(__name__)

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        username = request.form['nm']
        return redirect(url_for('post_login', username=username))
    else:
        # .args are the arguments listed in the url
        username = request.args.get('nm')
        return redirect(url_for('get_login', username=username))

@app.route('/get_login/<username>', methods=['GET'])
def get_login(username):
    return 'Welcome %s!' % username.upper()

@app.route('/post_login', methods=['POST'])
def post_login(username):
    return 'Welcome %s!' % username.upper()


if __name__ == '__main__':
    app.run(debug=True)