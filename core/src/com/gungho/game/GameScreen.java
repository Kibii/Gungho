package com.gungho.game;


import java.io.IOException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by Catherine Feldman on 1/23/16.
 */
public class GameScreen extends DefaultScreen implements InputProcessor {
    OrthographicCamera camera;
    //TODO fix dimensions
    private int width = 200;
    private int height = 200;
    GunghoGame game;
    private TiledMap map;
    //TODO fill in renderer
    private WorldRenderer renderer;
    Stage stage;


    //TODO fix issue with DefaultScreen constructor
    public GameScreen(GunghoGame game) {
        super(game);
        Gdx.input.setInputProcessor(this);

        //load map
        map = new TmxMapLoader().load("initial_map.tmx");

        //TODO add parameters to WorldRenderer
        renderer = new WorldRenderer(map);
        stage = new Stage(new ScreenViewport());


    }
    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.windowWidth, game.windowHeight);
        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(game.windowWidth, game.windowHeight, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.7f, 0.7f, 1.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // controller for player movement
        float deltaTime = Gdx.graphics.getDeltaTime();
       //TODO: Add for player movement
       // controller.update(map, deltaTime);



        // render map
        camera.update();
        renderer.setView(camera);
        renderer.render();

        stage.act(Math.min(delta, 1 / 30f));
        stage.draw();


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

    @Override
    public void dispose () {
        stage.dispose();
    }

}
