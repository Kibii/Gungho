package com.gungho.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.OrthographicCamera;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Catherine on 1/23/16.
 */
public class WorldRenderer extends OrthogonalTiledMapRenderer{
    private Sprite sprite;
    private List<Sprite> sprites;
    private int drawSpritesAfterLayer = 0;
    float stateTime = 0f;

    public WorldRenderer(TiledMap map) {
        super(map);
        sprites = new ArrayList<Sprite>();
    }

    public void addSprite(Sprite sprite){
        sprites.add(sprite);
    }

    @Override
    public void render() {
        beginRender();
        stateTime += Gdx.graphics.getDeltaTime();
        //batch.begin();
        int currentLayer = 0;

        for (MapLayer layer : map.getLayers()) {
            if (layer.isVisible()) {
                if (layer instanceof TiledMapTileLayer) {
                    renderTileLayer((TiledMapTileLayer)layer);
                    currentLayer++;
                    //TODO: walls layer < ornamental layer --> check to see if issue with collisions
                    if(currentLayer == drawSpritesAfterLayer){
                        for(Sprite sprite : sprites) {
                            sprite.draw(this.getBatch());
                        }
                    }
                } else {
                    for (MapObject object : layer.getObjects()) {
                        renderObject(object);
                    }
                }
            }
        }
        endRender();
    }
}
