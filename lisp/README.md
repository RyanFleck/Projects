[Link to pretty manual](https://ryanfleck.github.io/lisp.markdown)

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```lisp
(print "Hello World")
```

<https://learnxinyminutes.com/docs/common-lisp/>




Bwah, *LISP?* From the *50s?* Yes- Lisp is more common than you might think; often the "secret sauce" of successful companies like [Grammarly](https://tech.grammarly.com/blog/running-lisp-in-production) and [Amazon](https://groups.google.com/forum/#!topic/comp.lang.lisp/SD-8ULlEfy0%5B1-25%5D) is a finely crafted lispy back-end. Lisps are beautifully simple and functional tools; the following article contains my impressions as I begin to learn the CLISP dialect. While many speak poorly of its age, there have been a few occasions in the first 30 pages where I've been caught off guard by the effortlessness of construction and computation that lisp provides. I almost cried the first time I saw LISP handle rational numbers.



## The Book: Land of Lisp

> Lisp has been hailed as the world’s most powerful programming language, but its cryptic syntax and academic reputation can be enough to scare off even experienced programmers. Those dark days are finally over — Land of Lisp brings the power of functional programming to the people!

![Symbolics KB](https://ryanfleck.github.io/assets/SymbolicsKB.jpg)

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
```lisp
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

Obviously unfinished.

```lisp
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
