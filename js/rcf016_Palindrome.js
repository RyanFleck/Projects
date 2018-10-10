// Finds the largest palindrome of the product of two numbers under 1000.

const hibound = 999;
const lowbound = 900; // Hopefully the two nums are above this.
const palindromes = [];

// Brute Force.
for (let x = hibound; x > lowbound; x--) {
    for (let y = hibound; y > lowbound; y--) {
        const z = x * y;
        if (isPalindrome(z)) { palindromes.push(z); }
    }
}

palindromes.sort((a, b) => b - a); // Used internet. Research ES6 => notation.
console.log(`Largest palindrome: ${palindromes[0]}`);

// Fast implementation needed.

function isPalindrome(x) {
    xarr = x.toString().split('');
    a = 0;
    b = xarr.length - 1;
    while (b > a) {
        if (xarr[b] != xarr[a]) { return false; }
        a++;
        b--;
    }
    return true;
}
