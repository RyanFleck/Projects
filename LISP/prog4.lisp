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
