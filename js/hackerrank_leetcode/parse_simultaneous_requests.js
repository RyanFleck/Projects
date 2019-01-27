const { createReadStream, createWriteStream } = require('fs');
const { createInterface } = require('readline');
const stream = require('stream');

function main() {
    // read the string filename
    const filename = readLine();
    const matchobj = {};
    const file = createInterface({ input: createReadStream(`${__dirname}/${filename}`) });
    const outfile = createWriteStream(`${__dirname}/req_${filename}`);

    file
        .on('line', (l) => {
            const timestamp = l.match(/\[.*\]/);
            (timestamp in matchobj) ? matchobj[timestamp] += 1 : matchobj[timestamp] = 1;
        })
        .on('close', () => {
            const keys_matchobj = Object.keys(matchobj);
            const len_matchobj = keys_matchobj.length;
            const output = [];
            for (let y = 0; y < len_matchobj; y++) {
                if (matchobj[keys_matchobj[y]] > 1) {
                    output.push(keys_matchobj[y].substring(1, 21));
                }
            }
            output.forEach(x => outfile.write(x.concat('\n')));
            outfile.end();
        });
}

// i3