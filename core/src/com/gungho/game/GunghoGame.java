package com.gungho.game;

import com.badlogic.gdx.Game;

import com.gungho.game.mainmenu.MainMenuScreen;

public class GunghoGame extends Game {
	@Override
	public void create() {
		//setScreen(new MainMenuScreen(this));
		setScreen(new MainMenuScreen(this));
	}
}