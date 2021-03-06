import * as Phaser from 'phaser';

// Scenes
import LoadScene from './scenes/LoadScene';
import MenuScene from './scenes/MenuScene';
import DemoLevel from './scenes/DemoLevel';

const game = new Phaser.Game({
    /*
    width: window.innerWidth * window.devicePixelRatio,
    height: window.innerHeight * window.devicePixelRatio,
    */
    width: 400,
    height: 300,
    scene: [
        LoadScene,
        MenuScene,
        DemoLevel,
    ],
    render: {
        pixelArt: true,
    },
    scale: {
        parent: 'phaser',
        mode: Phaser.Scale.FIT,
        autoCenter: Phaser.Scale.CENTER_BOTH,
        width: 400,
        height: 300,
    },
});


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
