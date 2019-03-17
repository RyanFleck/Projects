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

        this.add.image(200, 150, 'title');
    }
}
