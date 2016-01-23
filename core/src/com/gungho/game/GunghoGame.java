package com.gungho.game;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gungho.game.mainmenu.MainMenuScreen;

public class GunghoGame extends Game {
	public int windowWidth;
	public int windowHeight;
	public String windowTitle;

	public GunghoGame() {
		windowWidth = 800;
		windowHeight = 600;
		windowTitle = "Gungho";
	}

	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}
}