package com.gungho.game;

import com.badlogic.gdx.Game;

public class GunghoGame extends Game {
	public static int windowWidth = 800;
	public static int windowHeight = 600;
	public static String windowTitle = "Gungho";

	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}
}