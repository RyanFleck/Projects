const sp = require('serialport');
const readline = require('readline');

const allports = [];
sp.list((err, ports) => {
    ports.forEach((port) => {
        console.log(port.comName);
        allports.push(port.comName);
    });
}).then(() => {
    console.log(allports);
    const port = allports[0]; // Depends on the machine.
    console.log(`Using ${port}`);
    const arduino = new sp(port, 9600);
    
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        terminal: true 
    });

    rl.on('line',(l)=>{
        arduino.write(l+'\n');
    });

}).catch(e => console.log(e));

/*
 * https://itp.nyu.edu/physcomp/labs/labs-serial-communication/lab-serial-communication-with-node-js/
 * x
 */
