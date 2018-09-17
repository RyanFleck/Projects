// PRIMITIVE types are stored as simple data.
// REFERENCE types are stored as objects and refer to locations in memory.

// Primitive Types:

// Strings
let name = 'Ryan'
let place = 'Ottawa'

// Numbers
let high = 49
let low = 12

// Booleans
let go = false

// Null & Undefined
let object = null
let flag
let flag2 // Automatically undefined.

// Primitive values use their own storage space:
console.log(ul('Test how primitives are stored:'))
let one = true
let two = one
console.log('Storage test: one=' + one + ', two=' + two + '.')
one = false // Two should not change, and remain TRUE.
console.log('Storage test: one=' + one + ', two=' + two + '.')
console.log((one != two) ? 'Tests passed.' : 'Tests failed.')

// Identifiy primitives with 'typeof'
console.log(ul('Identify Primitives with TYPEOF:'))
for (x of ['One', 'Two', 10, 5.1, true, false, undefined, null, 'String']) { console.log("  -'" + x + "' is of type " + (typeof x)) }

// Coercion
console.log(ul('Test Coercsion:'))
let string = '5'
let integer = 5
console.log((string == integer)
  ? " '5' == 5 returns true." : " '5' == 5 returns false.")
console.log((string === integer)
  ? " '5' === 5 returns true." : " '5' === 5 returns false.")

// Primitives can use methods:
console.log(ul('Primitive Methods:') + '\nStrings:')
console.log('toLowerCase\ttoUpperCase\tcharAt(0)\tsubstring(2,5)')
for (x of ['Paris    ', 'London  ', 'Shanghai', 'New York', 'Toronto ', '']) { console.log(x.toLowerCase() + '\t' + x.toUpperCase() + '\t' + x.charAt(0) + '\t\t' + x.substring(2, 5)) }

// Reference Types:
// Refs are instances of reference types, and synonymous with objects.
// Constructors begin with uppercase letters to distinguish them from vars.

// References do not use their own storage space:
console.log(ul('Test how references are stored:'))
let rone = { 'value': true }
let rtwo = rone // Two should point to, and not copy, one.
console.log('Storage test: one=' + rone.value + ', two=' + rtwo.value + '.')
rone.value = false // Two should change.
console.log('Storage test: one=' + rone.value + ', two=' + rtwo.value + '.')
console.log((rone.value != rtwo.value) ? 'Tests failed.' : 'Tests passed.')

// To help with mem management, it is good to dereference objects after use.
// Important for programs that use millions of objects.
rone = null
rtwo = null

// Properties can easily be added to objects:
console.log(ul('Add Properties to an Object:'))
let mug = new Object()
mug.color = 'Beige'
mug.weight = {}
mug.weight.value = 0.02
mug.weight.units = 'Kg'
mug.content = {}
mug.content.volume = {}
mug.content.volume.value = 200
mug.content.volume.units = 'mL'
mug.content.taxonomy = {}
mug.content.taxonomy.name = 'Green Tea'
mug.content.taxonomy.appearance = 'Green'
mug.content.taxonomy.teabag = true
// console.log("\nMug Properties:\n"+JSON.stringify(mug,null,2));
prObj('Mug', mug)

// Builtin Types:
// (Are these all good for ES6+ ?)
pul('Builtin Type Tests:')
let rarray = new Array()
let rdate = new Date()
let rerror = new Error('Hm?')
let rfunc = new Function()
let robj = new Object()
let rregex = new RegExp()

// Object Literal syntax can also be used:
let rlarray = ['one', 'two', 'three']
let rlobj = {
  'name': 'The best object.',
  'color': 'Red.'
}

// CHAPTER 1 PAGE 10

// Supportive methods:

function ul (str) {
  return ('\n\n' + str + '\n' + '-'.repeat(str.length))
}

function pul (str) { console.log(ul(str)) }

function prObj (name, obj) {
  console.log('\n' + name + ' Properties:\n' + JSON.stringify(obj, null, 2))
}
