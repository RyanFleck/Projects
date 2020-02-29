% Hello World web-server in Prolog.
% http://www.pathwayslms.com/swipltuts/html/

:- use_module(library(http/thread_httpd)).
:- use_module(library(http/http_dispatch)).
:- use_module(library(http/html_write)).

:- http_handler(root(hello_world), say_hi, []).
:- http_handler(/, home, []).

start(Port) :- http_server(http_dispatch, [port(Port)]).
start :- http_server(http_dispatch, [port(8000)]).

stop(Port) :- http_stop_server(Port, []).
stop :- http_stop_server(8000, []).


say_hi(_Request) :- 
  reply_html_page(
    title('Home'),[
      h1('Prolog WebApp'),
      p(['Hello',' goodbye.'])
    ] 
  ).

home(_Request) :-
  reply_html_page(
    title('Home'),[
      h1('Prolog WebApp'),
      p(['Hello',' goodbye.'])
    ] 
  ).

