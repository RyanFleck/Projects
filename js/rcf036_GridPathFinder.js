const r = require('./rcf_lib');

/*
 * This is the experiment when I realized doing computationally-expensive
 * calcuations was a terrible idea in a language like NodeJS, which is
 * singlethreaded. Future experiments like this will likely be written in
 * Scala or another functional language.
 */

// Settings
const gridSize = 10;
let paths = 0;

r.title('Grid Pathfinder');

/*
 * A tree must be built. Starting at the origin (0,0), a binary tree must be
 * formed so every branch has a final child ending at (n,n), where n is grid
 * size.
 *
 *  2 => 6
 *  3 => 20
 *  4 => 70
 *  5 => 252
 *  6 => 924
 *  7 => 3432
 *  ...
 *  10 => 184756
 *  20 >  2509300000... (Computation took too long.)
 *        137846528820 => What 20 will eventually add to, if this sequence is correct:
 *              http://oeis.org/search?q=6%2C20%2C70%2C252&language=english&go=Search
 *
 *    I had quite a ways to go. Time to design something more efficient?
 */

// Takes two dimensional array, builds paths.
async function buildPaths(arr) {
    r.subtitle(`Paths for ${arr.length - 1}-by-${arr[0].length - 1} square grid.`);
    // r.logSquareArray(arr);
    console.log('Calcuating...');
    addNode(arr, 0, 0).then(() => {
        console.log('Done.');
        console.log(`Paths: ${paths}`);
    });
}

async function addNode(sourceArray, y, x, builtArray = [0]) {
    // console.log(`[ AddNode ] On node ${y}${x}`);
    let terminate = true;

    // Check X++.
    if (typeof (sourceArray[y]) !== 'undefined' && typeof (sourceArray[y][x + 1]) !== 'undefined') {
        addNode(sourceArray, y, x + 1, builtArray.concat([sourceArray[y][x + 1]]));
        terminate = false;
    }

    // Check Y++.
    if (typeof (sourceArray[y + 1]) !== 'undefined' && typeof (sourceArray[y + 1][x]) !== 'undefined') {
        addNode(sourceArray, y + 1, x, builtArray.concat([sourceArray[y + 1][x]]));
        terminate = false;
    }

    // If neither are defined:
    if (terminate) {
        // console.log(builtArray);
        paths += 1;
    }
}

function addNodeEx1(sourceArray, y, x, builtArray = []) {
    console.log(`[ AddNode ] On node ${y}${x}`);
    console.log(builtArray);

    if (typeof (sourceArray[y]) !== 'undefined' && typeof (sourceArray[y][x]) !== 'undefined') {
        addNode(sourceArray, y + 1, x, builtArray.concat([sourceArray[x][y]]));
        addNode(sourceArray, y, x + 1, builtArray.concat([sourceArray[x][y]])); // push() nonfunctional?
    }
}

function nodemsg(y, x, arr) {
    console.log(`Checking node (${y},${x}) = ${arr[y][x]}`);
}

function shallowCopy(arr) {
    return Array.prototype.slice.call(arr);
}

/*
 * Solution set. Grids are generated, printed, run through the tree.
 */

// const twoByTwo = [[0, 1, 2], [3, 4, 5], [6, 7, 8]]; // Points
const grid = r.genGrid(gridSize);
buildPaths(grid);
// r.subtitle("Ten-by-Ten");
// r.logSquareArray(grid);
