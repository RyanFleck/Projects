# Ryan's Python 3 Manual


```python
print("Hello, World!")
```
## Python 3

*Empty for now!* This manual will be filled out in due time, when I trace back my steps and re-learn the language properly. For now, it is an empty shell.

## TK and GUIs.
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
