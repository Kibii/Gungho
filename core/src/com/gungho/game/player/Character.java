package com.gungho.game.player;

/**
 * Created by amullarx on 1/24/16.
 */

import com.badlogic.gdx.math.Vector2;
import com.gungho.game.InputController.*;

public class Character {

    private Vector2 position;
    private Direction characterDirection;
    private boolean isMoving = false;
    private float speed = 100.0f;

    private int width;
    private int height;

    public Character(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
    }

    public void update(float delta) {
        // Movement stuff
        float velocity = speed * delta;
        if(isMoving) {
            switch (characterDirection) {
                case NORTHWEST:
                    position.add(-velocity/2, velocity/2);
                    break;
                case NORTH:
                    position.add(0, velocity);
                    break;
                case NORTHEAST:
                    position.add(velocity/2, velocity/2);
                    break;
                case EAST:
                    position.add(0, velocity);
                    break;
                case SOUTHEAST:
                    position.add(velocity/2, -velocity/2);
                    break;
                case SOUTH:
                    position.add(0, -velocity);
                    break;
                case SOUTHWEST:
                    position.add(-velocity/2, -velocity/2);
                    break;
                case WEST:
                    position.add(-velocity, 0);
                    break;
                default:
                    break;
            }
        }
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }


}
