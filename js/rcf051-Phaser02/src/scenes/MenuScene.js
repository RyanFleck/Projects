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
        this.sound.play('title_music', {
            loop: true,
        });

        const lava = this.add.particles('lava').setDepth(1);
        const emitter = lava.createEmitter({
            // speed: 90,
            scale: { start: 0.7, end: 0 },
            x: 200,
            y: 255,
            speedX: { min: -30, max: 30 },
            speedY: { min: -20, max: -30 },
            lifespan: 800,
            gravityY: -200,
            blendMode: 'ADD',
        });


        emitter.start();

        this.add.image(200, 140, 'title').setDepth(1);
        this.add.image(200, 150, 'bg').setDepth(0);
        const playBtn = this.add.image(200, 260, 'play').setDepth(2);

        playBtn.setInteractive();

        playBtn.on('pointerover', () => {
            console.log('hovering.');
            emitter.set
        });

        playBtn.on('pointerout', () => {
            console.log('no longer hovering.');
        });

        playBtn.on('pointerup', () => {
            console.log('Play!');
        });
    }
}
