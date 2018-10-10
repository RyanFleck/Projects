// A Pythagorean triplet is a set of three natural numbers,
// a < b < c, for which a^2 + b^2 = c^2

// For example, 3^2 + 4^2 = 9 + 16 = 25 , 9+16+25 = 52.

// Find Pythagorean triplets for which a + b + c = limit.

// a < b < c , a+b+c = 1000, a^2 + b^2 = c^2

// Test functions:
console.log((testInequality(1, 2, 3)) ? '\ntestInequality()\tPASS 1' : '\ntestInequality()\tFAIL 1');
console.log((testInequality(1, 4, 3)) ? 'testInequality()\tFAIL 2' : 'testInequality()\tPASS 2');
console.log((testPythag(3, 4, 5)) ? 'testPythag()\t\tPASS 3' : 'testPythag()\t\tFAIL 3');
console.log((testPythag(3, 4, 6)) ? 'testPythag()\t\tFAIL 4\n' : 'testPythag()\t\tPASS 4\n');

const limit = 1000;
let a = 1;

while (a < limit) {
    const maxB = limit - a - 1;
    for (let b = a; b < maxB; b++) {
        const c = limit - a - b;
        // console.log("a:"+a+" b:"+b+" c:"+c);
        if (testPythag(a, b, c) && testInequality(a, b, c)) {
            console.log(`\nANSWER: a:${a} b:${b} c:${c}, product:${a * b * c}\n`);
            break;
        }
    }

    a++;
}

function testInequality(x, y, z) {
    // console.log("a:"+x+" b:"+y+" c:"+z+" a<b<c? "+( x < y && y < z ));
    return (x < y && y < z);
}

function testPythag(x, y, z) {
    // console.log("a:"+x+" b:"+y+" c:"+z+" Pythag? >>"+((x*x + y*y)== z*z));
    // console.log("a:"+x+" b:"+y+" c:"+z+" a+b+c=1K? >>"+((x + y + z)== 1000));
    return ((x * x + y * y) == z * z);
}
