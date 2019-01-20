const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', (inputStdin) => {
    inputString += inputStdin;
});

process.stdin.on('end', () => {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the compareTriplets function below.
function compareTriplets(a, b) {
    let a_pts = 0;
    let b_pts = 0;
    const arrlen = a.length;
    for (let i = 0; i < arrlen; i++) {
        console.log(i);
        if (a[i] == b[i]) continue;
        (a[i] > b[i]) ? a_pts++ : b_pts++;
    }

    return [a_pts, b_pts];
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const a = readLine().replace(/\s+$/g, '').split(' ').map(aTemp => parseInt(aTemp, 10));

    const b = readLine().replace(/\s+$/g, '').split(' ').map(bTemp => parseInt(bTemp, 10));

    const result = compareTriplets(a, b);

    ws.write(`${result.join(' ')}\n`);

    ws.end();
}
