RCF - Notes on common LISP, and the functional programming paradigm.

This compilation of thoughts regarding the general structure of common/ANSI Lisp is indended to be a personal and functional guide to the language, and so it follows no structure or logical syntax. 

Programming Language: CLISP (+ clojure arc etc)
Textbook(s): LAND OF LISP, various online sources.

To run xyz.lisp as interactive:
1. ANSI CLisp: `clisp -repl xyz.lisp`
2. GNU Common Lisp: `gcl -load xyz.lisp`
3. Steel Bank Common Lisp: `sbcl --load xyz.lisp`

Assign global variables:

(defparameter *foo* 12)


Define a function:

'''lisp
(defun function_one (arguments)
  ...)
'''


An arithmetic shift takes the bits in memory and shifts the number.

(ash *shiftnum* shiftamount)

So, for (ash 11 1), 11 will be shifted by 1 bit.

11 in binary is 1011, and a 'shift by 1' would be 10110, which is 16 + 4 + 2, 22 total.

(ash 11 1) returns 22.


