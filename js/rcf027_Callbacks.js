const r = require('./rcf_lib')
const _ = require('lodash')
const fs = require('fs')


r.title('Functional Programming Tests III (Questionable Asynchronicity)')

r.subtitle('Asynchronous Callbacks')

/*
 * someAsyncFunction( function( err, result ){})
 *
 * The results of someAsyncFunction are passed to the inner function as args:
 * ERR: Any errors the asynchronous function encounters. 
 * RESULT: The return value of the async function.
 */


