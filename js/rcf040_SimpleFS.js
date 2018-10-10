const fs = require('fs');

const data = fs.readdirSync('.');

console.log(`Data loaded: ${typeof data}  0th: ${data[0]}\n${data}`);