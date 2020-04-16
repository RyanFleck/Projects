#lang racket

; Write a Scheme function that accepts a list of numbers L and
; returns the frequency (number of times) of each number occurs
; in the list. The frequency is to be returned in a list of lists
; where each list contains the number as car and its frequency as
; the second element in the list as in the following examples

;;;; Implementation One

(define (frequency_a nums)
  (if (null? nums)
      '()
      (let ( (SortedNums (sort nums <)) )
        (sub_frequency_a (car SortedNums) SortedNums 0))))

(define (sub_frequency_a element numlist occurences)
  (cond
    ((null? numlist) (list (list element 1)))
    ((equal? element (car numlist))
     (sub_frequency_a element (cdr numlist) (+ occurences 1)))
    (else
     (cons (list element occurences) (sub_frequency_a (car numlist) (cdr numlist) 1)))))


;;;; Implementation Two

(define (frequency_b inputList)
  (if (null? inputList)
      '()
      (let ((sortedNums (sort inputList <)))
        ;;; Internal Algorithm. (letfunc? what is this??)
        (let subfunc ((Element (car sortedNums))
                      (Tail (cdr sortedNums))
                      (Occurences 1))

          (cond
            ((null? Tail) (list (list Element Occurences)))
            ((equal? Element (car Tail))
             (subfunc Element (cdr Tail) (+ Occurences 1)))
            (else
             (cons (list Element Occurences) (subfunc (car Tail) (cdr Tail) 1)))))
        )))


;;; Change algorithm to unit test:
(define frequency_algo frequency_b)

(displayln "\nTest Case 1:")
(frequency_algo '())
(displayln "'()")

(displayln "\nTest Case 2:")
(frequency_algo '(1 5 2 7 1 6 1 6 4))
(displayln "'((1 3) (2 1) (4 1) (5 1) (6 2) (7 1))")

(displayln "\nTest Case 3:")
(frequency_algo '(1 5 9 7 -1))
(displayln "'((-1 1) (1 1) (5 1) (7 1) (9 1))")
