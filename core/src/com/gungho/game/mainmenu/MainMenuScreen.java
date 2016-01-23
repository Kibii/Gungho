package com.gungho.game.mainmenu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.gungho.game.DefaultScreen;

/**
 * Created by Catherine Feldman & James Yanyuk on 1/23/16.
 */
public class MainMenuScreen extends DefaultScreen implements InputProcessor {
    OrthographicCamera camera;

    private int width = 200;
    private int height = 200;

    public MainMenuScreen(Game game) {
        super(game);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(width, height);
        camera.position.x = width / 2;
        camera.position.y = height / 2;
        camera.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
