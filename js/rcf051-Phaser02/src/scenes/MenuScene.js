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
            gravityY: -300,
            blendMode: 'ADD',
        });

        // Animations
        this.anims.create({
            key: 'knight-running',
            frames: this.anims.generateFrameNumbers(
                'tiles-tall',
                { frames: [73, 75] },
            ),
            frameRate: 3,
            repeat: -1,
        });

        const knight = this.add.sprite(95, 220, 'tiles-tall', 75).setDepth(2);
        knight.setScale(2);
        knight.anims.play('knight-running');

        emitter.start();

        this.add.image(200, 140, 'title').setDepth(1);
        this.add.image(200, 150, 'bg').setDepth(0);
        const playBtn = this.add.image(200, 260, 'play').setDepth(2);

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
    }
}
