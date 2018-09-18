# Ryan's Python 3 Manual

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual on [ryanfleck.github.io/py](https://ryanfleck.github.io/py)
  


[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```python
print("Hello, World!")
```
## Python 3

*Empty for now!* This manual will be filled out in due time, when I trace back my steps and re-learn the language properly. For now, it is an empty shell.

## Why I am Writing Programs in Python

## Pandas Data Analysis

*Pandas* is a Python library for creating and manipulating *dataframes*, allowing for easy organization and processing of data.

## TK and GUIs.

GUIS, or Graphical User Interfaces, are designed to allow the general public to interact with the software running beneath.

By default, Python uses TKinter (TK Interface) to create simple GUIs. Below is an simple example of a GUI with a window, a label, and a button.

```python
import tkinter as tk
top = tk.Tk()

l = tk.Label(top, text="Tiny GUI")
l.pack()

b = tk.Button(top,text="Button!")
b.pack()

top.title("RCF TK-Interface")
top.resizable(width=False, height=False)
top.geometry('{}x{}'.format(300, 60))
top.mainloop()
```
