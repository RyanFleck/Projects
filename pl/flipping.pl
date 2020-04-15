% Write a predicate flip.
% Flip is to exchange the order of pairs itself and in the list.

flip( [A|B], L ) :- 
    extract(B, C),
    flip(C, D),
    flip(A, E),
    concat(D, E, L).

flip( (A,B), (B,A) ).

extract([A|B],A).
concat(A, B, [A,B]).

test0(L) :- flip( [ (a, b), ( c, d)], L ). % L = [ (d,c), (b,a) ].