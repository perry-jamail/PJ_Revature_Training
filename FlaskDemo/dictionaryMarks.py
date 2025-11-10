from flask import Flask, render_template

app = Flask(__name__)

@app.route('/subjects')
def subjects():
    subDict = {
        'Physics': 88,
        'Chemistry': 72,
        'Math': 93
    }
    return render_template("subjects.html", result=subDict)




if __name__ == '__main__':
    app.run(debug=True)