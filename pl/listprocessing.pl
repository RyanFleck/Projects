% Decompose

writelist([]).
writelist([Head|Body]) :- writeln(Head), writelist(Body).

addSecond([_|Body],Total) :- addSecond(0, Body, Total), !.

%End case.
addSecond(_, [], Total) :- Total is 0.

% Even case.
addSecond(Count, [Head|Body], Total) :- 
  0 is mod(Count, 2), NewCount is Count + 1,
  addSecond(NewCount, Body, ChildTotal),
  Total is ChildTotal + Head.

% Odd case.
addSecond(Count, [_|Body], Total) :- 
  1 is mod(Count, 2), NewCount is Count + 1,
  addSecond(NewCount, Body, Total). % Total brought up directly.

