function getTopicCount(topic) {
    const https = require('https');
    const wiki = https.get(
        'https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page='.concat(topic.trim()),
        (res) => {
            const response_array = [];
            res.on('data', (x) => {
                response_array.push(x.toString());
            }).on('end', () => {
                console.log((response_array.join('').match(new RegExp(topic, 'g')) || []).length);
            }).on('error', (err) => {
                console.log(`ERR -> wiki -> res\n${err}`);
            });
        },
    ).on('error', (err) => {
        console.log(`ERR -> wiki \n${err}`);
    });
}

// i2