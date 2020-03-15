package com.sosoft.skyfighter.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.sosoft.skyfighter.heroes.Hero;

import static com.sosoft.skyfighter.levels.Constants.PPM;

public class LevelDrawer {

    boolean debug;
    OrthogonalTiledMapRenderer renderer;
    LevelCamera camera;
    Box2DDebugRenderer box2DDebugRenderer = new Box2DDebugRenderer();
    Level level;

    LevelDrawer(Level level, TiledMap tiledMap, boolean debug) {
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
        camera = new LevelCamera(level.players, tiledMap);
        this.level = level;
        this.debug = debug;
    }

    private void update() {
        camera.update();
        renderer.setView(camera);
    }

    public void updateAndRender() {
        update();
        Gdx.gl.glClearColor(0.1f, 0.5f, 0.5f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        renderer.getBatch().begin();
        if (debug)
            renderContactPoints();
        for (Hero player : level.players)
            player.draw(renderer.getBatch());
        renderer.getBatch().end();
        if (debug)
            box2DDebugRenderer.render(level.levelController.world, camera.combined.scl(PPM));
    }


    Texture tex = new Texture("badlogic.jpg");
    private void renderContactPoints() {
        for(int i = 0; i < level.levelController.world.getContactCount(); i++) {
            Contact contact = level.levelController.world.getContactList().get(i);
            for (int j = 0; j < contact.getWorldManifold().getNumberOfContactPoints(); j++) {
                Vector2 point = contact.getWorldManifold().getPoints()[j];
                renderer.getBatch().draw(tex, point.x * PPM, point.y * PPM, 20, 20);
            }
        }
    }

}