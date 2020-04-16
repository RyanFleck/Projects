#lang racket

; Write a function numOccur in Scheme which has arguments
; a number E and a list L and returns how many times the
; number E occurs in the list L.

(define (numOccur num list)
  (cond
    ((null? list) 0)
    ((equal? num (car list))
     (+ 1 (numOccur num (cdr list))))
    (else
     (numOccur num (cdr list)))
    ))

(numOccur 4 '(1 3 5 0 4 1 4 6)) ;2

(numOccur 4 '(1 7 5 0 8 1 8 6)) ;0

(numOccur 4 '()) ;0