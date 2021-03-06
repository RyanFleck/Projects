;;;; Prog3: Example usage of "cond"
;;;; RCF 2018 - Land of Lisp p.56

(defvar *arch-enemy* nil)
(defun pudding-eater (person)
  (cond
    ((eq person 'henry)
      (setf *arch-enemy* 'stupid-henry)
      '(Oh hi Henry.))
    ((eq person 'john)  
      (setf *arch-enemy* 'stupid-john)
      '(Oh hi John.))
    ((eq person 'mark)
      (setf *arch-enemy* 'stupid-mark)
      '(O hai Mark!))
    (t
      '(Who are you ?))
  )
)

(pudding-eater 'henry)
(pudding-eater 'mark)
(pudding-eater 'nobody)
