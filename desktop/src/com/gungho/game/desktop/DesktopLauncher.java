package com.gungho.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gungho.game.DannyDemo;
import com.gungho.game.GunghoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        //new LwjglApplication(new DannyDemo(), config);
		new LwjglApplication(new GunghoGame(), config);
	}
}
