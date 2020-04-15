(define (greaterThan x y) (if (< (cdr x) (cdr y)) y x))

(define (gcd a b)
  (if (= a b)
      a
      (if (> a b)
          (gcd (- a b) b)
          (gcd a (- b a)))))

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

(define (len list)
  (cond
    ((null? list) 0)
    (else
     (+ 1 (len (cdr list))))))


(define (sigmoid nnv)
  (/ 1 (+ (exp (* nnv -1)) 1)))

(ut "sigmoid")
(test 1.0067379469990854 (sigmoid 5))

(define (accumulatePairs seta setb)
  (cond
    ( (or (null? seta) (null? setb)) 0)
    (+ (* (car seta) (car setb))
       (accumulatePairs (cdr seta) (cdr setb)))))

(define ((neuralNode weights sigmoid) x)
  (sigmoid
   (+ (car weights) (accumulatePairs (cdr weights) x))))

(ut "neuralNode")
(neuralNode '(0.1 0.3 0.4) sigmoid)
((neuralNode '(0.1 0.3 0.4) sigmoid) '(0.5 0.5))


(define ((neuralLayer weights) x)
  (list
   ((neuralNode
     (list-ref weights 0) sigmoid) x)
   ((neuralNode
     (list-ref weights 1) sigmoid) x)
   ((neuralNode
     (list-ref weights 2) sigmoid) x)))

(ut "neuralLayer")
((neuralLayer '((0.1 0.3 0.4)(0.5 0.8 0.3)(0.7 0.6 0.6))) '(0.5 0.5))


(define layer-matrix '((0.1 0.3 0.4)(0.5 0.8 0.3)(0.7 0.6 0.6)))

(define (neuralNet x)
  (let ((z1 (car ((neuralLayer layer-matrix)x)))
        (z2 (cadr ((neuralLayer layer-matrix)x)))
        (z3 (caddr ((neuralLayer layer-matrix) x)))
        (b10 0.5)
        (b11 0.3)
        (b12 0.7)
        (b13 0.1)
        )
    
    (list
     (sigmoid (+ b10
                 (* b11 z1)
                 (* b12 z2)
                 (* b13 z3)
                 )))))


(neuralNet '(0.5 0.5))


