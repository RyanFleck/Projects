# Programming in Lisp

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/lisp](https://ryanfleck.github.io/lisp)
  

```cl
(defparameter *langs*
    '( clisp racket scheme ))

(princ "Hello, ")
(princ *langs*)
```



<br />




<br />


Bwah, *LISP?* From the *50s?* Yes- Lisp is more common than you might think; often the "secret sauce" of successful companies like [Grammarly](https://tech.grammarly.com/blog/running-lisp-in-production) and [Amazon](https://groups.google.com/forum/#!topic/comp.lang.lisp/SD-8ULlEfy0%5B1-25%5D) is a finely crafted lispy back-end. Lisps are beautifully simple and functional tools; the following article contains my impressions as I begin to learn the CLISP dialect. While many speak poorly of its age, there have been a few occasions in the first 30 pages where I've been caught off guard by the effortlessness of construction and computation that lisp provides. I almost cried the first time I saw LISP handle rational numbers.

It is important to note that there are many implementations of lisp, each with distinct advantages and disadvantages. For my learning, I'm going to be initially focusing on MIT lisps (adhering to the IEEE 1990 Scheme standard,) and SBCL, as these are what are used in my learning materials. Whether I settle with MIT-Scheme, Racket, Chicken or Guile depends on my mileage with each as I complete practice problems.

This manual contains snippets of all kinds of lisps. If I gravitate towards one in particular, say, Racket or Clojure, I'll breakout the lang-specific jargon into a separate manual.


## Why I am Writing Programs in Lisps

To expand my programming horizons, I chose to read a book on *CLisp*, which was fantastic. After this I began applying functional techniques everywhere else; these languages change the way you approach problems. I'm now reading through *SICP* and *Land of Lisp*, and enjoying both immensely.

Whichever LISP you use, I recommend using the `rlwrap` program to enhance your working experience. Running, for instance, `rlwrap guile` adds history, readline and bracket matching to the REPL, which can be a huge quality-of-life improvement.

## **Resource:** Land of Lisp

> Lisp has been hailed as the world’s most powerful programming language, but its cryptic syntax and academic reputation can be enough to scare off even experienced programmers. Those dark days are finally over — Land of Lisp brings the power of functional programming to the people!

![Symbolics KB](https://ryanfleck.github.io/assets/SymbolicsKB.jpg)


## **Resource:** SICP

MIT's *Structure and Interpretation of Computer Programs* is a classic in the truest sense; the material in the tome has been used in MIT's programs since 1980, and many of the core concepts have diffused out into reality, becoming the core of our global infrastructure. The book is available for free online in many forms.

## Other Resources

1. [Learn X in Y mins: Common Lisp](https://learnxinyminutes.com/docs/common-lisp/)

<br />

## CLISP Basics
1. Define a **global variable** with *defparameter*: `(defparameter *xyz* 18)`
  * AKA top-level definition, dynamic variable, special variable.
  * Don't forget the *earmuffs*!
  * `(defvar *xyz* 18)` will set but not overwrite.
2. Define a **global function** with *defun*: `(defun func_name (args))`
  * Functions appear after `(args)`:
  * `(defun example_function () (commands))`
3. Define and use **local varibles** with *let*.
  * `(let ((x 1)(y 2)) (commands))`
  * These variables are only active in the function body.
4. Define and use **local functions** with *flet*.
  * `(flet ((func_name (args) (commands))) (commands with function))`
  * Again, the function only works in the *flet* list.
  * Multple functions can be defined in the () after *flet*.
5. Like *flet*, *labels* defines local functions, but also allows recursive calls.

A simple number-guessing game, using arithmetic shifts (binary search,) can be written like so with a few global functions:

```cl
(defparameter *big* 100)
(defparameter *small* 1)

(defun guess-my-number ()
  (ash (+ *small* *big*) -1)
)
(defun smaller ()
  (setf *big* (1- (guess-my-number)))
  (guess-my-number)
)
(defun bigger ()
  (setf *small* (1+ (guess-my-number)))
  (guess-my-number)
)
(defun start-over ()
  (defparameter *small* 1)
  (defparameter *big* 100)
  (guess-my-number)
)
```
In higher-order functions, `#'x` stands in for (function x).

## Lisp Syntax

Here is another example program showing parameters being defined, functions being defined, string insertions, comments, and more:

```cl
;;;; Prog5: "Wizard Adventure Game"
;;;; RCF 2018 - Land of Lisp p.70

(defparameter *nodes*
  '(
    (living-room
    (you are in the living-room. a wizard is snoring loudly on the couch.))
    (garden
    (you are in a beautiful garden. a well is in front of you.))
    (attic
    (you are in the attic. there is a giant welding torch in the corner.))))

(defparameter *edges*
 '(
    (living-room (garden west door) (attic upstairs ladder))
    (garden (living-room east door))
    (attic (lving-room downstairs ladder))))

(defparameter *objects*'(whiskey bucket frog chain))

(defparameter *object-locations*
  '(
      (whiskey living-room)
      (bucket living-room)
      (chain garden)
      (frog garden)))


(defun describe-location (location nodes)
  (cadr (assoc location nodes)))

(defun describe-path (edge)
  `(there is a ,(caddr edge) going ,(cadr edge) from here.))


(defun describe-paths (location edges)
  (apply #'append
    (mapcar #'describe-path
      (cdr (assoc location edges)))))

(defun objects-at (loc objs obj-locs)
  (labels
    ((at-loc-p (obj)
      (eq (cadr (assoc obj obj-locs)) loc)))
      (remove-if-not #'at-loc-p objs)))
```

# Catalogue of LISPs

## MIT Scheme

The first time you install `mit-scheme` and run the REPL with `scheme`, you'll be greeted with all sorts of hackerisms:

```
MIT/GNU Scheme running under GNU/Linux
Type `^C' (control-C) followed by `H' to obtain information about interrupts.

Copyright (C) 2011 Massachusetts Institute of Technology
This is free software; see the source for copying conditions. There is NO 
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

Image saved on Saturday December 3, 2016 at 9:44:07 AM
Release 9.1.1 || Microcode 15.3 || Runtime 15.7 || SF 4.41 || LIAR/x86-64 4.118
Edwin 3.116

1 ]=> (exit)

Kill Scheme (y or n)? Yes
Moriturus te saluto.
```

MIT Scheme is recommended for learning and applying the contents of *SICP*.

## GUILE

```
GNU Guile 2.0.13
Copyright (C) 1995-2016 Free Software Foundation, Inc.

Guile comes with ABSOLUTELY NO WARRANTY; for details type `,show w'.
This program is free software, and you are welcome to redistribute it
under certain conditions; type `,show c' for details.

Enter `,help' for help.
scheme@(guile-user)> (exit)
```

## Racket

```
Welcome to Racket v6.7.
> (exit)
```

