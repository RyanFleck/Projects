#lang scheme

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



(define (for-each func lst)
  (let loop ((rest lst))
    (unless (null? rest)
      (func (car rest))
      (loop (cdr rest)))))

(ut "for-each")
(for-each (lambda (a) (displayln (* 2 a))) '(1 2 3 4))


(define (contains-str x list)
  ;(display "Checking list ")
  ;(display list)
  ;(display " for string ")
  ;(displayln x)
  (cond
    ((null? list) #f)
    ((void? list) #f)
    ((string? list)
     (string=? x list)
     )
    ((pair? (car list))
     (if (contains-str x (car list))
         #t
         (contains-str x (cdr list)))
     )
    ((list? (car list))
     (if (contains-str x (car list))
         #t
         (contains-str x (cdr list)))
     )
    ((eq? x (car list)) #t)
    (else (contains-str x (cdr list)))))

(ut "contains-str")
(test #t (contains-str "Hello" '("Hello")))
(test #t (contains-str "Hello" '("Test" "One" "Two" "Hello" "Is me.")))
(test #t (contains-str "Hello" '("Test" "One" ("Two" "Hello") "Is me.")))
(test #f (contains-str "Hello" '("Test" "One" ("Two" "Bye") "Is me.")))
(test #f (contains-str "Hello" '("Test" ("Oh" . "No") "One" ("Two" "Bye") "Is me.")))
(test #t (contains-str "Hello" '("Test" ("Oh" . "No") "One" ("Two" "Bye" ("Ho" . "Hello")) "Is me.")))



(define (all-true list)
  (cond
    ((null? list) #t)
    ((not (eq? #t (car list))) #f)
    (else (all-true (cdr list)))))

(ut "all-true")
(test #t (all-true '(#t #t #t)))
(test #f (all-true '(#t #f #t)))



(define (list-position item list)
  (cond
    ((null? list) -2)
    ((eq? item (car list)) 0)
    (else (- (list-position item (cdr list)) 1))))

(ut "list-position")
(test 0 (list-position 1 '(1 0 3 2)))
(test -1 (list-position 1 '(2 1 0 3 2)))
(test 0 (list-position "A" '("A" 0 3 2)))
(test -1 (list-position "A" '(2 "A" 0 3 2)))
(test -3 (list-position "A" '(2 "C" 5 "A" 0 3 2)))




;;; CSV Stuff.
(define (printLines in)
  (let ((line (read-line in 'any)))
    (if (not
         (or
          (eof-object? line)
          (void? line)
          (null? line)
          ))
        ((displayln line) (printLines in))
        (newline)
        )))

(define (lines-to-strings in last)
  (let ((line (read-line in 'any)))
    (if (not
         (or
          (eof-object? line)
          (void? line)
          (null? line)
          ))
        (lines-to-strings in (cons line last))
        last
        )))

(define (sublist-by-comma string-in) (string-split string-in ",")) 

(define (csvToList fileName)
  (display "\nImporting ")
  (displayln fileName)
  (let ( (in (open-input-file fileName)) )
    (let ( (output (map sublist-by-comma (lines-to-strings in '()))) )
      (close-input-port in)
      output)
    )
  )



;;; Solution Helpers
(define (allmatched employers matches)
  (all-true (map
             ; For each employer, check if they are matched
             (lambda (employer)
               (contains-str employer matches)
               )
             ; Using the name of each employer
             (map (lambda
                      (employer) (car employer))
                  employers)
             )))


;;; Match format (employer student priority)
(define (match employer student priority)
  (cons employer (cons student (cons priority '()) ) ))

(define (match-employer match) (car match))
(define (match-student match) (cadr match))
(define (match-priority match) (caddr match))

(define (get-student-match student matches)
  (cond
    ((null? matches) (match "unmatched" "unmatched" 0))
    ((string=? student (match-student (car matches))) (car matches))
    (else (get-student-match student (cdr matches)))))

(ut "get-student-match")
(test "Sophia"
      (cadr (get-student-match "Sophia"
                               '(("Thales" "Olivia" 0)
                                 ("Canada Post" "Sophia" 0)
                                 ("Cisco" "Fig Newton" 0)))))
(test "unmatched"
      (cadr (get-student-match "Mark"
                               '(("Thales" "Olivia" 0)
                                 ("Canada Post" "Sophia" 0)
                                 ("Cisco" "Fig Newton" 0)))))


(define (list-position-str item list)
  (cond
    ((null? list) -2)
    ((string=? item (car list)) 0)
    (else (- (list-position-str item (cdr list)) 1))))

(define (student-priority employer student students)
  (cond
    ((null? students) -100000000)
    ((string=? student (caar students))
     (list-position-str employer (cdar students)))
    (else
     (begin
       (student-priority employer student (cdr students))))))

(ut "student-priority")
(test 0 (student-priority "Cisco" "Mark"
                          '( ("Amelia" "Costco") ("Mark" "Cisco")  )))
(test -1 (student-priority "Cisco" "Mark"
                           '( ("Amelia" "Costco") ("Mark" "Canada Post" "Cisco")  )))


(displayln "====================================================")
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Evaluate
(define (evaluate employer employer-choice students matches)
  (displayln "\nEVALUATE")
  (display "Evaluating offer for ")(displayln employer)
  (display "Against students: ")(displayln students)
  (display "Using matches: ")(displayln matches)
  (display "Choice ")(display employer-choice)(display " match: ")
  (displayln (car (get-student-match employer-choice matches)))
  (cond

    ;;; If no more students to check, return the matches.
    ((null? students) matches)

    ;;; If no matches, take initiative.
    ((null? matches)
     (displayln "No matches, adding first.")
     (cons (match employer employer-choice
             (student-priority employer employer-choice students))matches))

    ;;; If first employer choice is unmatched, take initiative.
    ((string=? "unmatched" (car (get-student-match employer-choice matches)))
     (display "Matching ")(display employer)
     (display " with ")(displayln employer-choice)
     (cons (match employer employer-choice
             (student-priority employer employer-choice students)) matches))

    ;;; If student is already matched.
    (else
     (begin;;;;;;;;;;;;;;
       
       (evaluate employer employer-choice (cdr students) matches)

       
       );;;;;;;;;;;;;;;;;
  
     )))

;;; Offer
(define (offer employer employer-choices students matches)
  (displayln "\nOFFER")
  (if (contains-str employer matches)
      matches
      (begin
        ; If the employer is unmatched
        (display "Employer ")(display employer)(displayln " is unmatched.")
        (offer employer (cdr employer-choices) (cdr students)
               (evaluate employer (car employer-choices) students matches)))))
    

(define (addMatches employers students matches)
  (cond
    ((null? employers) matches)
    (else
     (display "Checking employer ")
     (displayln (caar employers))
     (display "Matches: ")
     (displayln matches)
     (addMatches (cdr employers) students (offer (caar employers) (cdar employers) students matches))
     )))

(define (stableMatchingLoop employers students matches)
  (displayln "\n\nEnter stable matching loop.")
  (display "All matched? => ")
  (displayln (allmatched employers matches))
  (if (not (allmatched employers matches))
      (begin
        (displayln "\nChecking employers...")
        (stableMatchingLoop
         employers
         students
         (addMatches employers students matches)
         )
        )
      matches))

;;; Solution
(define (stableMatching L_employer_preferences L_student_preferences)
  (displayln "\n\nMcVitie-Wilson Stable Matching Algorithm")
  (stableMatchingLoop L_employer_preferences L_student_preferences '())
  )

(csvToList "coop_s_3x3.txt")

(csvToList "coop_e_3x3.txt")

(stableMatching (csvToList "coop_e_3x3.txt") (csvToList "coop_s_3x3.txt"))

;(csvToList "coop_e_10x10.csv")

;(csvToList "coop_s_10x10.csv")

;(stableMatching (csvToList "coop_e_10x10.csv") (csvToList "coop_s_10x10.csv"))