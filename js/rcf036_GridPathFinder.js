const r = require('./rcf_lib')

r.title('Grid Pathfinder')

// Synchronous implementation:

const twoByTwo = [ [0, 1, 2], [3, 4, 5], [6, 7, 8] ]

r.logSquareArray(twoByTwo)

const entryExists = (arr, y, x) => (typeof arr[y] !== 'undefined' && typeof arr[y][x + 1] !== 'undefined')

const movOpts = (arr, y, x) => {
  console.log(entryExists(arr, y, x))
}

movOpts(twoByTwo, 133, 13)
movOpts(twoByTwo, 0, 13)
movOpts(twoByTwo, 0, 0)
