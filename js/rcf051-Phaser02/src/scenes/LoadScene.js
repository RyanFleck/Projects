/* eslint-disable class-methods-use-this */

import * as Phaser from 'phaser';
import { CST } from '../CST';

export default class LoadScene extends Phaser.Scene {
    constructor() {
        super({
            key: CST.SCENES.LOAD,
        });
    }

    preload() {
        this.load.audio('title_music', './audio/JDB Artist - Inspirational Vol.2 - 01 New Day New Dawn (Adventure).mp3');

        this.load.image('lava', './sprites/lava.png');
        this.load.image('logo', './sprites/logo.png');
        this.load.image('title', './sprites/title.png');
        this.load.image('bg', './sprites/IntroBackground.png');
        this.load.image('play', './sprites/play.png');
        this.load.spritesheet('tiles', './sprites/DungeonTileset.png', {
            frameHeight: 16,
            frameWidth: 16,
        });
        this.load.spritesheet('tiles-tall', './sprites/DungeonTileset.png', {
            frameHeight: 32,
            frameWidth: 16,
        });

        const loadingBar = this.add.graphics({
            fillStyle: {
                color: 0xffffff,
            },
        });

        this.load.on('progress', (percent) => {
            loadingBar.fillRect(0,
                this.game.renderer.height / 2,
                this.game.renderer.width * percent, 50);
            console.log(`Loading: ${Math.floor(percent * 100)}%`);
        });
    }

    create() {
        // x
        this.scene.start(CST.SCENES.MENU, 'Loaded assets.');
    }
}
