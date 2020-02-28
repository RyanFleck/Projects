addSecond([_|Body],Total) :- addSecond(0, Body, Total), !.

addSecond(Count, [Head|Body], Total) :- 
  0 is mod(Count, 2), % Even.
  NewCount is Count + 1,
  addSecond(NewCount, Body, ChildTotal),
  Total is ChildTotal + Head.

addSecond(Count, [_|Body], Total) :- 
  1 is mod(Count, 2), % Odd.
  NewCount is Count + 1,
  addSecond(NewCount, Body, Total).

addSecond(_, [], Total) :- Total is 0.

