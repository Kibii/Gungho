package com.gungho.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gungho.game.GunghoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		GunghoGame game = new GunghoGame();
		new LwjglApplication(game, game.windowTitle, game.windowWidth, game.windowHeight);
	}
}
