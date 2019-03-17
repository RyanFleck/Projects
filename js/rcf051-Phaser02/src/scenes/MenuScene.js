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
        console.log('I got it.');
    }

    create() {
        // x
    }
}
