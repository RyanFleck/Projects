;;;; Prog4: Example usage of "case"
;;;; RCF 2018 - Land of Lisp

(defvar *description* nil)
(defun d-scribe (person)
  (case person
    ((henry)
      (setf *description* 'tall-hairy-man) '(this is henry))
    ((johnny) 
      (setf *description* 'short-bald-man) '(this is johnny))
    (otherwise 
      (setf *description* 'not-in-database) '(unknown))
  )
)

(d-scribe 'henry)

(print *description*)
