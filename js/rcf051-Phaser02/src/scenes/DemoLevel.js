/* eslint-disable class-methods-use-this */

import * as Phaser from 'phaser';
import { CST } from '../CST';

export default class DemoLevel extends Phaser.Scene {
    constructor() {
        super({
            key: CST.SCENES.DEMO,
        });
    }

    init(data) {
        console.log(data);
    }

    create() {
        const lava = this.add.particles('lava').setDepth(1);
        const emitter = lava.createEmitter({
            // speed: 90,
            scale: { start: 1, end: 0 },
            x: 200,
            y: 255,
            speedX: { min: -50, max: 50 },
            speedY: { min: -20, max: -70 },
            lifespan: 1000,
            gravityY: -200,
            blendMode: 'ADD',
        });


        emitter.start();
    }
}
