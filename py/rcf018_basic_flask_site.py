from flask import Flask, render_template_string

app = Flask(__name__)

basepage = '''<!DOCTYPE html>
<html>
    <head>
        <title>RCF.FLASK.TEST</title>
        <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Mono:400,400i,600" rel="stylesheet">
        <style>
            body {
                background: #333;
                color: #DDD;
                width: 35em;
                margin: 0 auto;
                font-family: 'IBM Plex Mono', Verdana, Arial, sans-serif;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
                font-size: 20px;
            }
            .quiet {
                color: #777;
                text-align: right;
            }
            a{
                color: #FFF;
            }
        </style>
    </head>

    <body>
        <h1>{{title}}</h1>
        {{content}}
        <br />
        <p class="quiet">19&Omega;</p>
    </body>

</html>
'''


@app.route('/')
def hello():
    return(render_template_string(
        basepage,
        title="Welcome to my Flask Site",
        content="Hello, World! The page was generated on "+
    ))


app.run()
