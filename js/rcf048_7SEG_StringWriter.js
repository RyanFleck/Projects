const sp = require('serialport');

const { Readline } = sp.parsers;

const allports = [];
sp.list((err, ports) => {
    ports.forEach((port) => {
        console.log(port.comName);
        allports.push(port.comName);
    });
}).then(() => {
    console.log(allports);
    const port = allports[allports.length - 1];
    console.log(`Using ${port}`);
    const arduino = new sp(port, 9600);

    const parser = new Readline();
    arduino.pipe(parser);
}).catch(e => console.log(e));

/*
 * https://itp.nyu.edu/physcomp/labs/labs-serial-communication/lab-serial-communication-with-node-js/
 * x
 */
