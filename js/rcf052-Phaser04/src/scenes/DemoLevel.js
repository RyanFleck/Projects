/* eslint-disable class-methods-use-this */

import * as Phaser from 'phaser';
import { CST } from '../CST';

export default class DemoLevel extends Phaser.Scene {

    constructor() {
        super({
            key: CST.SCENES.DEMO,
        });
        this.state = {};
    }

    init(data) {
        console.log(data);
    }

    create() {
        this.state.cursors = this.input.keyboard.createCursorKeys();
        this.state.player = this.add.circle(100,100,10,0xFFFFFF);
    }

    update() {
        const s = this.state;
        const c = s.cursors;

        if( c.right.isDown ){
            s.player.x += 3;
        }

        if( c.left.isDown ){
            s.player.x -= 3;
        }

        if( c.up.isDown ){
            s.player.y -= 3;
        }

        if( c.down.isDown ){
            s.player.y += 3;
        }


    }
}
