#lang racket

; Write a top-level define absDiff that calculates the absolute difference of the corresponding
; elements of two lists. The function also evaluates to a list. Check if the list have the same
; length otherwise return an error. You are given the auxiliary routine loop.


(define (loop LA LB)
  (if (or (null? LA) (null? LB))
      '()
      (cons (abs (- (car LA) (car LB))) (loop (cdr LA) (cdr LB)))))

(define (absDiff LA LB)
  (if (not (equal? (length LA) (length LB)))
      "Lists have differing lengths."
      (loop LA LB)))
  
(absDiff '(1 3 5 6) '(3 5 2 1))
;  =>	(2 2 3 5)

(absDiff '(1 3 5 6 7) '(3 5 2 1)) 
; => "List have different length"



  