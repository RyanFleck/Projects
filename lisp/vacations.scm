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


(define (getcountries choicelist) (cadar (cdadar choicelist)))
(define (firstChoice choices) (cadar choices))

(define (buildScores choices)
  (cond ((null? choices) '())
        (else
         (cons
          (cons (car choices) 0)
          (buildScores (cdr choices))
          ))))

(define (length list)
  (cond ((null? list) 0)
        (else(+ 1 (length (cdr list))))))


;;; Solution
(define (destination choices)
  (let (
        (countries (getcountries choices))
        (maxScore (len (getcountries choices)))
        )
    ;(display "Using countries ")
    ;(display countries) (newline)
    (buildScores countries)
    (addscores choices (buildScores countries) maxScore)
    ))


(define (addscores choices scores max)
  (cond ((null? choices) scores)
        (else
         ;(display "Checking ")
         ;(display (firstChoice choices)) (newline)
         (topscore
          (addscores
           (cdr choices)
           (processUserScores (cadadr (firstChoice choices)) scores max)
           max)))))


(define (processUserScores priorities scores max)
  ;; Takes a list of user scores and adds them to the list.
  (cond ((null? priorities) scores)
        (else

         (processUserScores
          (cdr priorities)
          (incscore (car priorities) max scores)
          (- max 1)
          )
         )))

(define (incscore country amount scores)
  (cond
    ((null? scores) '())
    ((void? scores) '())
    ((string=? country (caar scores))
     (cons
      (cons (caar scores) (+ (cdar scores) amount))
      (incscore country amount (cdr scores))
      ))
    (else
     (cons
      (cons (caar scores) (cdar scores))
      (incscore country amount (cdr scores))
      )
     )
    ))

(define (topscore scores)
  (checkCountryScore scores (getTopScore scores))
  )

(define (checkCountryScore scores top)
  (cond
    ((null? scores) '())
    ((>= (cdar scores) top)
     (cons (car scores) (checkCountryScore (cdr scores) top)))
    (else
     (checkCountryScore (cdr scores) top))
    )
  )

(define (getTopScore scores)
  (cond
    ((null? scores) 0)
    (else
     (cond
       ((> (cdar scores) (getTopScore (cdr scores))) (cdar scores))
       (else (getTopScore (cdr scores)))))))


(define choices1 '('("marie" '("peru" "greece" "vietnam"))
                   '("jean" '("greece" "peru" "vietnam"))
                   '("sasha" '("vietnam" "peru" "greece"))
                   '("helena" '("peru" "vietnam" "greece"))
                   '("emma" '("greece" "peru" "vietnam"))))

(define choices2 '('("marie" '("peru" "greece" "vietnam"))
                   '("jean" '("greece" "peru" "vietnam"))
                   '("sasha" '("vietnam" "peru" "greece"))
                   '("helena" '("peru" "vietnam" "greece"))
                   '("emma" '("greece" "peru" "vietnam"))
                   '("jane" '("greece" "vietnam" "peru"))))

(destination choices1)

(destination choices2)