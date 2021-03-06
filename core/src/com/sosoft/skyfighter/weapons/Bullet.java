package com.sosoft.skyfighter.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.sosoft.skyfighter.heroes.Hero;

import static com.sosoft.skyfighter.levels.Constants.*;
import static java.lang.Math.pow;

public class Bullet {
    public final static float INFDISTANCE = -1f;
    public final static float INFTIME = -1f;


    // CHARACTERISTICS
    public int damage;
    public float speed;
    public float maxDistance;
    public float maxTimeAlive;
    public boolean canBounce;
    public float accyuracy;
    public String spriteName;
    public float scale;
    public float density;

    float timeAlive;
    float distance;
    Vector2 pos;
    Vector2 startPos;
    public Body body;
    Texture texture;
    Sprite sprite;
    World world;
    public boolean endOfLife;
    public Hero hero;
    public Weapon weapon;

    public Bullet(Weapon weapon, BulletDef bulletDef) {
        hero = weapon.hero;
        this.weapon = weapon;
        damage = (int)((float)bulletDef.damage * (random.nextFloat() * DAMAGE_SCATTER_RANGE * 2 + (1 - DAMAGE_SCATTER_RANGE)));
        speed = bulletDef.speed;
        maxDistance = bulletDef.maxDistance;
        maxTimeAlive = bulletDef.maxTimeAlive;
        canBounce = bulletDef.canBounce;
        accyuracy = bulletDef.accuracy;
        spriteName = bulletDef.spriteName;
        scale = bulletDef.scale;
        density = bulletDef.density;
        init();
    }

    public void init() {
        this.world = hero.world;
        startPos = new Vector2(hero.centerPos);
        startPos.add(hero.weapon.posOffset);
        if (maxDistance != INFDISTANCE)
            this.maxDistance = maxDistance * maxDistance;
        else
            this.maxDistance = maxDistance;
        texture = new Texture(spriteName);
        sprite = new Sprite(texture);
        sprite.setOriginCenter();
        sprite.setScale(scale);
        timeAlive = 0f;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(startPos.x / PPM, startPos.y / PPM);
        bodyDef.bullet = true;
        bodyDef.fixedRotation = false;
        bodyDef.gravityScale = 0;
        bodyDef.angle = hero.state.aimAngle + (random.nextFloat() - 0.5f) * 180f * (1f - accyuracy);
        bodyDef.linearVelocity.set(new Vector2(speed, speed).setAngle(bodyDef.angle));

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.3f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = density;
        if (canBounce)
            fixtureDef.restitution = 0.9f;
        else
            fixtureDef.restitution = 0f;
        fixtureDef.shape = circleShape;
        fixtureDef.filter.maskBits = (short) (0xFFFF ^ (short) pow(2, hero.number));
        circleShape.dispose();

        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        body.setUserData(this);
    }


    public void update(float delta) {
        pos = body.getPosition().scl(PPM);
        distance = startPos.dst2(pos);
        timeAlive += delta;
        checkIfEnd();
    }

    public void draw(Batch batch) {
        sprite.setPosition(pos.x - sprite.getWidth() / 2, pos.y - sprite.getHeight() / 2);
        sprite.setRotation(body.getLinearVelocity().angle() - 90);
        sprite.draw(batch);
    }

    private void checkIfEnd() {
        if ((distance > maxDistance && maxDistance != INFDISTANCE) ||
                (timeAlive > maxTimeAlive && maxTimeAlive != INFTIME) ||
                pos.x < -400 ||
                pos.y < -400 ||
                pos.x > hero.levelController.level.levelDrawer.camera.mapWidth + 400 ||
                pos.y > hero.levelController.level.levelDrawer.camera.mapHeight + 400) {
            endOfLife = true;
        }
    }

    private void doWhenEnd() {

    }

    public void dispose() {
        texture.dispose();
    }
}
