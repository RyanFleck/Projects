from flask import Flask, render_template_string, request
import time

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
    debugRequest(request)
    return(render_template_string(
        basepage,
        title="Welcome to my Flask Site",
        content="Hello, World! The page was generated on "
        + time.strftime("%A %B %-d at %H:%M:%S (%z).", time.localtime())
        + " Flask is pretty neat. It allows you to make tiny, simple web"
        + " applications in a quick, clean and easily-deployable manner."
    ))

@app.route('/<string:name>')
def levelone(name):
    debugRequest(request)
    return(render_template_string(
        basepage,
        title=name.strip().title(),
        content="Welcome to the "+name.strip().title()+" page, which was generated on "
        + time.strftime("%A %B %-d at %H:%M:%S (%z).", time.localtime())
        + " Flask is pretty neat. It allows you to make tiny, simple web"
        + " applications in a quick, clean and easily-deployable manner."
    ))
    

@app.errorhandler(404)
def couldnt_find_page(e):
    debugRequest(request)
    response=''
    errored_page = request.args.get('url')
    if( errored_page ):
        response = 'The page '+errored_page+' does not exist.'
    return(render_template_string(
        basepage,
        title="LOL, 404!",
        content= response + str(e)
    ))

def debugRequest(request):
    print( request )
    print( request.get_json() )

app.run()
