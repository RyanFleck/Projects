; To run, execute: scheme < prog6.scm
; SICP Newton's Method for calculating square roots

(define (square x) (* x x))

(define (sqrt x)

    (define (good-enough? guess)
        (< (abs (- (square guess) x)) 0.001))

    (define (improve guess)
        (/ (+ (/ x guess) guess) 2))

    (define (iterate guess)
        (if (good-enough? guess)
        guess
        (iterate (improve guess))))

    (iterate 1.0))

(sqrt 104)
;Value: 10.198039027421274

(square (sqrt 104))
;Value: 104.00000000480743

; Note that all definitions required to run sqrt are included inside the
; definition, meaning they are block scoped and can access lexically scoped
; variable x.
