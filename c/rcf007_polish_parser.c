/*
 *  rcf007_polish_parser.c - Implements a grammar parser for polish
 *   mathematical notation in preparation for building a lisp.
 *
 *  Copyright (C) 2018 Ryan Fleck under the GNU GPLv3.
 *
 *  Prerequisites: mpc.c, mpc.h, libedit-dev.
 *   MPC repo at <github.com/orangeduck/mpc> 
 *
 *  Compilation Instructions:  
 *   (GNU/Linux) cc -stc=c99 -Wall <file> mpc.c -ledit -lm
 */

#include<stdio.h>
#include<stdlib.h>
#include<editline/readline.h>
#include<editline/history.h>
#include"mpc.h"			//Included in this repo.

int main(int argc, char **argv)
{

    mpc_parser_t *Number = mpc_new("number");
    mpc_parser_t *Operator = mpc_new("operator");
    mpc_parser_t *Expr = mpc_new("expr");
    mpc_parser_t *RML = mpc_new("rml");

    //Regular expressions that describe the grammar.
    mpca_lang(MPCA_LANG_DEFAULT,
	      "                                                    \
    number   : /-?[0-9]+/ ;                            \
    operator : '+' | '-' | '*' | '/' ;                 \
    expr     : <number> | '(' <operator> <expr>+ ')' ; \
    rml      : /^/ '(' <operator> <expr>+ ')' /$/ ;    \
  ", Number, Operator, Expr, RML);

    //Enter REPL, exit LIGHT:
    puts("Ryan's Micro LISP (RML) Version 0.0.0.4");
    puts("Press Ctrl+C to Exit\n");

    while (1) {
	char *input = readline("rml > ");
	mpc_result_t r;

	add_history(input);

	if (mpc_parse("<stdin>", input, RML, &r)) {
	    mpc_ast_print(r.output);	//Yay, syntax tree! 
	    mpc_ast_delete(r.output);
	} else {
	    mpc_err_print(r.error);
	    mpc_err_delete(r.error);
	}

	free(input);
    }

    return 0;
}
