#lang racket
; Enter your code here. Read input from STDIN. Print output to STDOUT

(define n (string->number (read-line)))
(define (repeater f count) (for((i (in-range count))) (f)))
(repeater (lambda () (displayln "Hello World")) n)