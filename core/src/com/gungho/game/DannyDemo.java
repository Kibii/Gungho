package com.gungho.game;

/**
 * Created by amullarx on 1/23/16.
 */

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DannyDemo implements ApplicationListener {
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;

    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture("Danny.png");
        sprite = new Sprite(texture);
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(0 < sprite.getX())
                sprite.translateX(-10f);
            else
                sprite.setX(0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
           // if(batch. > sprite.getX())
                sprite.translateX(10f);
           /* else
                sprite.setX(0);*/
        }
        batch.begin();
        sprite.draw(batch);
        batch.end();
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
}