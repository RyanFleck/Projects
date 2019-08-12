#lang racket

(require web-server/servlet
         web-server/servlet-env)

(define (start req)
    (response/xexpr
        `(html (head (title "Hello World!"))
            (body 
                (h1 "Hello!")
                (p "This servlet was written in Racket!")))))

(serve/servlet start)
