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

let obj = null

fs.readFile('./poetry/poe_alone.json', 'utf8', (err, data) => {
  if (err) { throw err }
  obj = JSON.parse(data)
  r.jsonf(obj)
  console.log(obj.poem)
})

r.jsonf(obj) // Will log 'null' as readFile has not finished.

// Any code affected by variables set within an async function should be placed
//  within the callback where the data is returned.

// async/await not a part of ths course?
