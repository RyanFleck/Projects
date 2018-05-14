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
