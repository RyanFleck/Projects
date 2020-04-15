(define (ut func)
  (display "\n\nUnit Tests for: ")
  (displayln func))

(define (test expected func)
  (display "Expected: ")
  (display expected)
  (display " Result: ")
  (let ((result func))
    (display result)
    (if (eq? expected result)
        (displayln " => PASS")
        (displayln " => FAIL")
        )))

(define (notzero x)
  (not (eq? 0 x)))

(define (changeList x)
  (filter notzero (map picky x)))

(define (picky x)
  (cond
    ((and
      (>= x 1)
      (<= x 1)) (* x 0))
    
    ((> x 1) (* x 10))
    
    ((< x -1) (/ 1 (* -1 x)))
    
    (else 0)))


(changeList '(0 -2 3 -4 1))