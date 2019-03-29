; To run, execute: scheme < prog6.scm
; Ideally, throw it in your .vimrc bound to an Fkey.

(+ 3 2)

(define (square x) (* x x))

(define (twist x y) (+ (square (+ x y)) (square (- x y))))

(twist 1 8) ; 130

; Test if number is greater than or equal to three.
(define (gethree x) 
    (cond 
        ( (= x 3) 1 )
        ( (> x 3) 1 )
        ( (< x 3) 0 )
    ))

(gethree 1) ; False
(gethree 3) ; True
(gethree (twist 6 9)) ; True

; Test if x is greater or equal to y.
(define (gey x y) 
    (cond 
        ( (> x y) 1 ) ; This is a clause.
        ( (= x y) 1 )
          ; Predicate
        ( (< x y) 0 )
                  ; Consequent Expression 
    ))

(gey 3 4)
(gey 4 3)
(gey 6 9) ; False 
; kek

; Programming is fun.

(define (absolutely? x) 
    (cond 
        ( (> x 0) x )
        ( else (- x))
    ))

(absolutely? 3)
(absolutely? -90)

; Alternative to cond, if.
;   (if <predicate> <consequent> <alternative>)
(define (ifabs x) (if (> x 0) x (- x)) )

(ifabs 30)
(ifabs -32)

; Boolean ops and, or and not can be used in the predicates of if, cond.
;   (and <e1> <e2>)   (or <e1> <e2>)   (not <e>)

(define (>= a b) (not (< a b))) ; Example from SICP page 26

(>= 2 5)
(>= 8 5)

; Square Roots problem. Apply Newton's Method.

(define (avg x y) (/ (+ x y) 2))
(avg 3.0 4.0)

(define (iter target guess) (avg (/ target guess ) guess))

; Manual Iteration:
(iter 2 1)
(iter 2 1.5)
(iter 2 1.41666)

; Accuracy check for function f
(define (accurate? f guess actual) 
    (< (abs (- (f guess) actual) 0.001) )

; Automatic iteration:
; ( Continue on Page 32 )
