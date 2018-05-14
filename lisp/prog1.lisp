;;;; Prog1: Basic LISP structures.
;;;; RCF 2018 - Land of Lisp p.21

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
