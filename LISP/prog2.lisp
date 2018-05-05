(print "List Eater")

(defun has_items (list)
  (if list
      '(true)
      '(false) ))

(defun chklen (list)
  (if list
      (1+ (chklen (cdr list))) 
      0
))

(defun chklenV2 (list)
  (if list
      (1+ (chklenV2 (cdr list))) 
      ()
))

(defun chklenV3 (list)
  (if list
      (1+ (chklenV3 (cdr list))) 
      '(false)
))
