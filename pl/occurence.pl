equal(A,B):- A is B.

test(Expectation, Reality) :- equal(Expectation, Reality).

% Write a predicate numOccur in Prolog which is true if the number E 
% occurs R times in the list. 

numOccur(A, B, C) :- subNumOccur(A, B, C, 0), !.

subNumOccur(_,[],A,B) :- A is B.

subNumOccur(A,[B|C],D,E) :- A is B,  Ep is E+1, 
    subNumOccur(A, C, D, Ep).

subNumOccur(A,[B|C],D,E) :- not(A is B), 
    subNumOccur(A, C, D, E).


test1 :- numOccur(4, [1, 7, 5, 0, 4, 1, 4, 6], R), test(R, 2).
test2 :- numOccur(4, [9, 3, 2, 0, 8, 1, 8, 6], R), test(R, 0).
test3 :- numOccur(4, [ ], R), test(R, 0).

