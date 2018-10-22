const r = require('./rcf_lib');

// Settings
const gridSize = 10;

r.title('Grid Pathfinder');

const entryExists = (arr, y, x) => (typeof arr[y] !== 'undefined' && typeof arr[y][x + 1] !== 'undefined');

/*
 * A tree must be built. Starting at the origin (0,0), a binary tree must be
 * formed so every branch has a final child ending at (n,n), where n is grid
 * size. 
 */


// Takes two dimensional array, builds paths.
function buildPaths(arr){
    r.logSquareArray(arr);
    const z = addNode(arr,0,0,[]);
    return z; 
}
function addNode(arr, y, x, array){
    var complete = true;
    console.log(typeof array);
    console.log(array);
    const narray = array.slice();

    if(entryExists(arr,y,(x+1))){
        nodemsg(x,y,arr);
        addNode(arr,y,(x+1),narray.push(arr[y][x+1]));
        complete = false;
    }
    
    if(entryExists(arr,(y+1),x)){
        nodemsg(y,x,arr);
        addNode(arr,(y+1),x,narray.push(arr[y+1][x])); //Fix: Pass arrays by value.
        complete = false;
    }

    if(complete){
        console.log(narray); 
    }
}

function nodemsg(y,x,arr){
    console.log(`Checking node (${y},${x}) = ${arr[y][x]}`);
}

/*
 * Solution set. Grids are generated, printed, run through the tree.
 */

const twoByTwo = [[0, 1, 2], [3, 4, 5], [6, 7, 8]]; // Points
const grid = r.genGrid(gridSize); // Write GenGrid

r.subtitle("Two-by-Two");
buildPaths(twoByTwo);
//r.subtitle("Ten-by-Ten");
//r.logSquareArray(grid);
