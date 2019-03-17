import * as Phaser from 'phaser';

// Scenes
import LoadScene from './scenes/LoadScene';
import MenuScene from './scenes/MenuScene';

const game = new Phaser.Game({
    width: 400,
    height: 300,
    scene: [
        LoadScene,
        MenuScene,
    ],
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
