/* eslint-disable class-methods-use-this */

import * as Phaser from 'phaser';
import { CST } from '../CST';

export default class LoadScene extends Phaser.Scene {
    constructor() {
        super({
            key: CST.SCENES.LOAD,
        });
    }

    create() {
        console.log('Create loadscene.');
        this.scene.start(CST.SCENES.MENU, 'Data passed to menu.');
    }
}
