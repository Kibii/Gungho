package com.gungho.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.gungho.game.player.Character;
import com.gungho.game.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Created by amullarx on 1/23/16.
 */
public class GameWorld {

    private Rectangle rect = new Rectangle(0, 0, 17, 12);

    private Texture texture;
    private Sprite sprite;
    private SpriteBatch batch;

    private List<Character> mobs;

    public GameWorld() {
        batch = new SpriteBatch();
        texture = new Texture("Danny.png");
        sprite = new Sprite(texture);

        mobs = new ArrayList<Character>(10);
        // Test adding
        mobs.add(new Player(33, 100 - 5, 17, 12));
    }

    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }

        // Move every character onscreen
        for(Iterator iterator = mobs.iterator(); iterator.hasNext();) {
            Character mob = (Character)iterator.next();
            mob.update(delta);
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
