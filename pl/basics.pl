#!/usr/bin/swipl
% Run by opening SWI-Prolog with 'swipl' and running consult(basics).

% In Prolog, you can specify facts, rules, and questions. 

% A collection of facts is a *database*:
friend(ryan, john). % ryan is friends with john.
likes(john, mary). % john likes mary.
valuable(gold). % gold is valuable.
owns(john, gold). %john owns gold.
gives(john, gold, ryan). % john gives the gold to ryan.
king(ryan, england). % ryan is the king of england.

vegetarian(cow).
vegetarian(sheep).

omnivore(bear).

carnivore(lion).
carnivore(eagle).

% :- "if" is the head of a clause.
animal(X) :- carnivore(X); omnivore(X); vegetarian(X).
friends(X, Y) :- friend(X, Y); friend(Y, X). % friendships are reciprocal
go :- write("Hello, World!"),nl.
hello(X) :- write("Hello, "),write(X),nl.

% Some built in predicates:
% halt, statistics, trace, nl, write

% 11
