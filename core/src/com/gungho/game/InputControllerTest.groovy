package com.gungho.game

/**
 * Created by amullarx on 1/23/16.
 */
import com.badlogic.gdx.Input
import com.gungho.game.player.Player;

class InputControllerTest extends groovy.util.GroovyTestCase {
    void testKeyDown() {
    InputController inCont = new InputController(new Player());
        inCont.keyDown(Input.Keys.UP);
        inCont.keyDown(Input.Keys.UP);
        assertEquals(1, inCont.numInputs());
        inCont.clearInputs();

        inCont.keyDown(Input.Keys.UP);
        inCont.keyDown(Input.Keys.DOWN);
        assertEquals(1, inCont.numInputs());
        inCont.clearInputs();

        inCont.keyDown(Input.Keys.UP);
        inCont.keyDown(Input.Keys.DOWN);
        inCont.keyDown(Input.Keys.LEFT);
        inCont.keyDown(Input.Keys.UP);
        assertEquals(2, inCont.numInputs());
        inCont.clearInputs();

        inCont.keyDown(Input.Keys.UP);
        inCont.keyDown(Input.Keys.LEFT);
        List<Integer> input = [Input.Keys.UP, Input.Keys.LEFT]
        List<Integer> directions = inCont.getDirections();
        for(int i = 0; i < input.size(); i++) {
            assertEquals(input[i], directions[i]);
        }
        assertEquals(Direction.NORTHWEST, inCont.getCurrentDirection());
        //inCont.movementDirection();
    }

    void testKeyUp() {
        InputController inCont = new InputController(new Player());

        inCont.keyDown(Input.Keys.DOWN);
        inCont.keyDown(Input.Keys.RIGHT);
        inCont.keyUp(Input.Keys.DOWN);
        assertEquals(1, inCont.numInputs());
        assertEquals(Direction.EAST, inCont.getCurrentDirection());

    }
}
