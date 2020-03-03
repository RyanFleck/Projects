% Unifies a list without duplicate entries from the first.

unify([],B,B).

unify([E|A],B,D) :- member(E,B), unify(A,B,D).

unify([E|A], B, [E|D]) :- not(member(E,B)), unify(A,B,D).
