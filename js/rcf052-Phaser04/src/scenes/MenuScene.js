/* eslint-disable class-methods-use-this */

import * as Phaser from 'phaser';
import { CST } from '../CST';

export default class MenuScene extends Phaser.Scene {
    constructor() {
        super({
            key: CST.SCENES.MENU,
        });
    }

    init(data) {
        console.log(data);
    }

    create() {
        /*
        this.sound.play('title_music', {
            loop: true,
        });
        */



        /*
        playBtn.setInteractive();
        playBtn.input.useHandCursor = true;

        playBtn.on('pointerover', () => {
            console.log('hovering.');
            this.game.canvas.style.cursor = 'pointer';
        });

        playBtn.on('pointerout', () => {
            console.log('no longer hovering.');
            this.game.canvas.style.cursor = 'default';
        });

        playBtn.on('pointerup', () => {
            console.log('Play!');
            this.game.canvas.style.cursor = 'default';
            this.scene.start(CST.SCENES.DEMO, 'Loaded assets.');
        });
        */

        this.scene.start(CST.SCENES.DEMO, 'Begin demo level.');
    }
}
