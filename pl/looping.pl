% Looping tests.

countDownA(N) :- repeat, writeln(N), N is N-1, N<0, !. % Broken.

countDownB(N) :- N > 0, writeln(N), X is N-1, countDownB(X).

loopC(N) :- N>0, write('The value is: '), write(N), nl, M is N-1, loopC(M).

loop_from_upto(From, UpTo) :- writeln(From), 
  From =\= UpTo, 
  From < UpTo,
  X is From + 1, loop_from_upto(X, UpTo).

sumto(1,1) :- !.
sumto(N,S):-N>1,N1 is N-1, sumto(N1,S1), S is S1 + N.

writesquares(1) :- !.
writesquares(N) :- N>1, W is N-1, writesquares(W), W2 is W * W, writeln(W2).

% Recursion.

floppotron :- ft_loop(start).
ft_loop(quit).
ft_loop(X) :- X \= quit, read(Word), write('Input was >> '), writeln(Word), ft_loop(Word).

% Disjunctive floppotron.
floppotron_dj :- read(Word), write('Input was >> '), writeln(Word), ( Word = end ; floppotron_dj ).


