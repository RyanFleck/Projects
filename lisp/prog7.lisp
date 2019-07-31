;; Learning Common Lisp from scratch.
;; https://lisp-lang.org/learn/first-steps

(format t "Hello, World!~%")

;; Baby steps into the lang, give myself some easy ways to output.
(defun ezprint (something) (format t "~A~%" something))
(defun section (sec) (format t "~%====> Section ~A~%" sec))

(section "One: Fun-ctions with DEFUN")

(defun add (a b) (+ a b))
(defun increment (a) (+ 1 a))

(ezprint (add 1 2))
(ezprint (apply #'add '(1 2)))

(section "Two: Variables")
;; let assigns local variables.
(let ((str "Hello, World!"))
    (ezprint (string-upcase str)))
    ;; ^^ This is called dynamic extent.

;; for globals use defparameter or defvar (no initial arg needed.)
(defparameter *aglobal* "Neato")
(defvar *anotherglobal*)

(section "Three: Lists!!!")

(defparameter *samplelist* '(1 2 3 foo bar baz))
(ezprint (fourth *samplelist*)) ;; prints FOO.
(setf (nth 3 *samplelist*) "Fear")
(ezprint (nth 3 *samplelist*)) ;; prints Fear.

(section "Four: Map!")

(defparameter *numbers* '(47 3 23 9 10 9 33 38 26))
(ezprint *numbers*)

(ezprint (mapcar (defun inc (a) (+ 1 a)) *numbers*))
;; A-Ha!
(ezprint (mapcar (lambda (a) (+ 1 a)) *numbers*))
