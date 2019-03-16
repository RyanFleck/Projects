const path = require('path');

module.exports = {
    entry: './src/main.js',
    mode: 'development',
    output: {
        filename: 'game.js',
        path: path.resolve(__dirname, 'dist'),
    },
};
