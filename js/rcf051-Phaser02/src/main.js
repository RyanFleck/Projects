import * as Phaser from 'phaser';

// import Npc from './inc/npc';

const config = {
    type: Phaser.AUTO,
    width: 800,
    height: 600,
    physics: {
        default: 'arcade',
        arcade: {
            gravity: { y: 0 },
        },
    },
    scene: {
        preload,
        create,
        update,
    },

};

const game = new Phaser.Game(config);
let player;
let cursors;


function preload() {
    this.load.setBaseURL('./sprites');

    this.load.image('rink', 'backdrop-base.png');
    this.load.image('boards', 'backdrop-transparent-boards.png');
    this.load.spritesheet('player', 'player-sheet.png',
        { frameWidth: 32, frameHeight: 32 });
}

function create() {
    this.add.image(400, 300, 'rink');
    this.add.image(400, 300, 'boards');

    player = this.physics.add.sprite(400, 300, 'player');
    cursors = this.input.keyboard.createCursorKeys();

    player.setBounce(0.2);
    player.setCollideWorldBounds(true);

    this.anims.create({
        key: 'right',
        frames: this.anims.generateFrameNumbers('player', { start: 15, end: 17 }),
        frameRate: 10,
        repeat: -1,
    });

    this.anims.create({
        key: 'left',
        frames: this.anims.generateFrameNumbers('player', { start: 12, end: 14 }),
        frameRate: 10,
        repeat: -1,
    });

    this.anims.create({
        key: 'up',
        frames: this.anims.generateFrameNumbers('player', { start: 1, end: 4 }),
        frameRate: 5,
        repeat: -1,
    });

    this.anims.create({
        key: 'down',
        frames: this.anims.generateFrameNumbers('player', { start: 25, end: 28 }),
        frameRate: 8,
        repeat: -1,
    });

    this.anims.create({
        key: 'stop',
        frames: [{ key: 'player', frame: 8 }],
        frameRate: 20,
    });

    this.cameras.main.setZoom(1);
}

function update() {
    let xmotion = true;
    let ymotion = true;

    if (cursors.left.isDown) {
        player.setVelocityX(-160);
        player.anims.play('left', true);
    } else if (cursors.right.isDown) {
        player.setVelocityX(160);
        player.anims.play('right', true);
    } else {
        player.setVelocityX(0);
        xmotion = false;
    }

    if (cursors.up.isDown) {
        player.setVelocityY(-160);
        player.anims.play('up', true);
    } else if (cursors.down.isDown) {
        player.setVelocityY(160);
        player.anims.play('down', true);
    } else {
        player.setVelocityY(0);
        ymotion = false;
    }

    if (!xmotion && !ymotion) {
        player.anims.play('stop');
    }
}

/* NOTES FOR NEXT TIME:

https://phaser.io/tutorials/coding-tips-005
http://nautil.us/issue/70/variables/how-designers-engineer-luck-into-video-games-rp

- Utilize tiled tilemaps.
- Learn to use the physics engine for collisions.

this.pacman.scale.x = 1;
this.pacman.angle = 0;

if (direction === Phaser.LEFT)
{
    this.pacman.scale.x = -1;
}
else if (direction === Phaser.UP)
{
    this.pacman.angle = 270;
}
else if (direction === Phaser.DOWN)
{
    this.pacman.angle = 90;
}

*/
