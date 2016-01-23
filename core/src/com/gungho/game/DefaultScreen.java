package com.gungho.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Created by jamesyanyuk on 1/23/16.
 */
public abstract class DefaultScreen implements Screen {
    protected Game game;

    public DefaultScreen(Game game) {
        this.game = game;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
