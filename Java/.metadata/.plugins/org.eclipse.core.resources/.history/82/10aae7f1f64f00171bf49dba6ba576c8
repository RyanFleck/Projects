package com.libgdx.battlecommander.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libgdx.battlecommander.BattleCommander;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "BATTLE COMMANDER";
		config.width = 800;
		config.height = 600;
		
		//Ryan's temp configs:
		config.resizable = true;
		config.backgroundFPS = 30;
		config.foregroundFPS = 60;
		config.useGL30 = true;
		
		new LwjglApplication(new BattleCommander(), config);
	}
}
