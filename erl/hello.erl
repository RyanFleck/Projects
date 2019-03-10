-module(hello).
-export([world/0]).
-export([start/0]).

% Hello-World function in Erlang
world() -> io:fwrite("Hello, Erlang!\n").

start() ->
    hello:world().

% compile with:
%  erlc hello.erl
% run with:
%  erl -noshell -s hello start -s init stop

