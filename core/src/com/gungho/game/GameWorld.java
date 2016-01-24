package com.gungho.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by amullarx on 1/23/16.
 */
public class GameWorld {

    private Rectangle rect = new Rectangle(0, 0, 17, 12);

    private Texture texture;
    private Sprite sprite;
    private SpriteBatch batch;

    public GameWorld() {
        batch = new SpriteBatch();
        texture = new Texture("Danny.png");
        sprite = new Sprite(texture);
    }

    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }

        sprite.setPosition(rect.x, sprite.getY());

        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    public Rectangle getRect() {
        return rect;
    }
}
