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


(define (groups x)
  (cond
    ((null? x) '())
    ((list? (car x))
     (if (< 1 (len x))
         (begin
           (if (eq? (caar x) (cadr x))
               (groups (cons (cons (cadr x) (car x)) (cddr x)))
               (cons (car x) (groups (cdr x))))) x ))
    (else
     (groups (cons (cons (car x) '()) (cdr x))))))

(ut "Groups")
(groups '( 0 1 5 3 3 3 3 2 1 1 4 1))

(define (greater a b)
  (if (> a b)
      a
      b))

(define (longestSubList x)
  (cond
    ((null? x) 0)
    (else
     (greater (len (car x)) (longestSubList (cdr x))))))
  
(longestSubList (groups '( 0 1 5 3 3 3 3 2 1 1 4 1)))

(define (getListOfLength x lists)
  (if (eq? (len (car lists)) x)
      (car lists)
      (getListOfLength x (cdr lists))))

(define (sameNum x)
  (let ((groupings (groups x)))
    (getListOfLength (longestSubList groupings) groupings)))


(ut "SameNum")
(sameNum '( 0 1 5 3 3 3 2 1 1))

(sameNum '( 0 1 5 3 3 3 3 3 2 1 1 1))