package com.gungho.game;

/**
 * Created by amullarx on 1/23/16.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import java.util.List;
import java.util.Iterator;

import com.gungho.game.player.Player;
import com.sun.tools.javac.code.Attribute;

import java.util.ArrayList;

public class InputController implements InputProcessor {
    public static enum Direction {
        NORTHWEST, NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST
    }
    private final int UP_KEY = Input.Keys.UP;
    private final int DOWN_KEY = Input.Keys.DOWN;
    private final int LEFT_KEY = Input.Keys.LEFT;
    private final int RIGHT_KEY = Input.Keys.RIGHT;
    private final int FIRE_KEY = Input.Keys.SPACE;

    private List<Integer> directionalInputList;
    private Direction currentDirection;
    private boolean isMoving;

    private Player player;

    public InputController(Player player) {
        directionalInputList = new ArrayList<Integer>();
        currentDirection = null;
        this.player = player;
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
                        updateCurrentDirection();
                        break;
                    case DOWN_KEY:
                        if (directionalInputList.contains(UP_KEY)) {
                            directionalInputList.remove(new Integer(UP_KEY));
                        }
                        directionalInputList.add(keycode);
                        updateCurrentDirection();
                        break;
                    case LEFT_KEY:
                        if (directionalInputList.contains(RIGHT_KEY)) {
                            directionalInputList.remove(new Integer(RIGHT_KEY));
                        }
                        directionalInputList.add(keycode);
                        updateCurrentDirection();
                        break;
                    case RIGHT_KEY:
                        if (directionalInputList.contains(LEFT_KEY)) {
                            directionalInputList.remove(new Integer(LEFT_KEY));
                        }
                        directionalInputList.add(keycode);
                        updateCurrentDirection();
                        break;
                    default:
                        break;
                }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(directionalInputList.contains(keycode)) {
            directionalInputList.remove(new Integer(keycode));
            updateCurrentDirection();
        }
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

    public Direction getCurrentDirection() {
        return currentDirection;
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

    private void updateCurrentDirection() {
        if(directionalInputList.size() == 1) {
            switch (directionalInputList.get(0)) {
                case UP_KEY:
                    currentDirection = Direction.NORTH;
                    break;
                case DOWN_KEY:
                    currentDirection = Direction.SOUTH;
                    break;
                case LEFT_KEY:
                    currentDirection = Direction.WEST;
                    break;
                case RIGHT_KEY:
                    currentDirection = Direction.EAST;
                    break;
                default:
                    break;
            }
        }
        else if(directionalInputList.size() == 2) {
            switch (directionalInputList.get(1)) {
                case UP_KEY:
                    if(directionalInputList.get(0) == LEFT_KEY)
                        currentDirection = Direction.NORTHWEST;
                    else
                        currentDirection = Direction.NORTHEAST;
                    break;
                case DOWN_KEY:
                    if(directionalInputList.get(0) == LEFT_KEY)
                        currentDirection = Direction.SOUTHWEST;
                    else
                        currentDirection = Direction.SOUTHEAST;
                    break;
                case LEFT_KEY:
                    if(directionalInputList.get(0) == UP_KEY)
                        currentDirection = Direction.NORTHWEST;
                    else
                        currentDirection = Direction.SOUTHWEST;
                    break;
                case RIGHT_KEY:
                    if(directionalInputList.get(0) == UP_KEY)
                        currentDirection = Direction.NORTHEAST;
                    else
                        currentDirection = Direction.SOUTHEAST;
                    break;
                default:
                    break;
            }
        }
    }


}
