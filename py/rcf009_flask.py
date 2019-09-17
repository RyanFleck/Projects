#!/usr/bin/python3
"""rcf009_flask.py

Simple tinkering file for the FLASK framework.

Windows:
    set FLASK_APP=rcf009_flask.py
    flask run

GNU/Linux:
    export FLASK_APP=rcf009_flask.py
    flask run
"""

from flask import Flask

APP = Flask(__name__)


@APP.route("/")
def hello():
    """Canonical greeting."""
    return "Hello, World!"
