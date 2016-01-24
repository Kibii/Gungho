package com.gungho.game;

/**
 * Created by amullarx on 1/23/16.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import java.util.List;
import java.util.Iterator;
import com.sun.tools.javac.code.Attribute;

import java.util.ArrayList;

public class InputController implements InputProcessor {
    private final int UP_KEY = Input.Keys.UP;
    private final int DOWN_KEY = Input.Keys.DOWN;
    private final int LEFT_KEY = Input.Keys.LEFT;
    private final int RIGHT_KEY = Input.Keys.RIGHT;
    private final int FIRE_KEY = Input.Keys.SPACE;

    private List<Integer> directionalInputList;

    public InputController() {
    directionalInputList = new ArrayList<Integer>();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == FIRE_KEY) {
            // TODO: Fire projectile in direction
        }
        else if (directionalInputList.size() < 2 && !directionalInputList.contains(keycode)) {
                switch (keycode) {
                    case UP_KEY:
                        if (directionalInputList.contains(DOWN_KEY)) {
                            directionalInputList.remove(new Integer(DOWN_KEY));
                        }
                        directionalInputList.add(keycode);
                        break;
                    case DOWN_KEY:
                        if (directionalInputList.contains(UP_KEY)) {
                            directionalInputList.remove(new Integer(UP_KEY));
                        }
                        directionalInputList.add(keycode);
                        break;
                    case LEFT_KEY:
                        if (directionalInputList.contains(RIGHT_KEY)) {
                            directionalInputList.remove(new Integer(RIGHT_KEY));
                        }
                        directionalInputList.add(keycode);
                        break;
                    case RIGHT_KEY:
                        if (directionalInputList.contains(LEFT_KEY)) {
                            directionalInputList.remove(new Integer(LEFT_KEY));
                        }
                        directionalInputList.add(keycode);
                        break;
                    default:
                        break;
                }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(directionalInputList.contains(keycode))
            directionalInputList.remove(new Integer(keycode));
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
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

    public void clearInputs() {
        directionalInputList.clear();
    }

    public int numInputs() {
        return directionalInputList.size();
    }

    public void movementDirection() {
        for (Iterator i = directionalInputList.iterator(); i.hasNext();) {
            System.out.print(i);
        }
    }

    public List<Integer> getDirections() {
        return directionalInputList;
    }

}
