


%interval(X,L,H) :- number(X), number(L), number(H), !, X >= L, X =< H.
%interval(X,X,H) :- number(X), number(H), X =< H.
%interval(X,L,H) :- number(L), number(H), L < H, L1 is L + 1, interval(X, L1, H).


interval(X,L,H) :- number(X), number(L), number(H), !, X >= L, X =< H.
interval(X,X,H) :- number(X), number(H), X =< H.
interval(X,L,H) :- number(L), number(H), L < H, L1 is L+1, interval(X,L1,H).

sumNodes(T,L) :- sumNodes( T, __________, L, __________).

sumNodes(nil,L,L,_) :-!.

sumNodes(t(Root,Left,Right),_________,________,_______) :-
    _______ is Root + ________,
    sumNodes(Left,_________,________,_______),
    sumNodes(Right,_________,________,_______),
    append(_________,________,_______).
