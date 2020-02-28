animal(mammal, tiger, carnivore, stripes).
animal(mammal, hyena, carnivore, ugly).
animal(mammal, lion, carnivore, mane).
animal(mammal, zebra, herbivore, stripes).
animal(bird, eagle, carnivore, large).
animal(bird, sparrow, scavenger, small).
animal(reptile, snake, carnivore, long).
animal(reptile, lizard, scavenger, small).

person(bill, male).
person(george, male).
person(alfred, male).
person(carol, female).
person(mararet, female).
person(jane, female).

couple(Man, Woman) :- person(Man, male), person(Woman, female), !.
couple(Woman, Man) :- couple(Man, Woman).

positive(X) :- X=ryan, !.
positive(X) :- X>0, write(positive),nl, !.
positive(0) :- write(zero),nl, !.
positive(X) :- X<0, write(negative),nl.
