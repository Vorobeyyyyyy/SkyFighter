package com.sosoft.skyfighter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class AnimatedSprite {
    float duration;
    float currentTime;
    Vector2 posOffset;
    int frameCount;
    int currentFrame;
    Array<Texture> textureArray;
    Array<Sprite> spriteArray;
    public Sprite currentSprite;
    public Vector2 size = new Vector2();

    public AnimatedSprite(String baseName, int frameCount, float duration, float scale) {
        textureArray = new Array<Texture>();
        spriteArray = new Array<Sprite>();
        for (int i = 0; i < frameCount; i++)
            textureArray.add(new Texture(baseName + String.valueOf(i) + ".png"));
        for (Texture texture : textureArray)
            spriteArray.add(new Sprite(texture));
        for (Sprite sprite : spriteArray) {
            sprite.setSize(sprite.getWidth() * scale, sprite.getHeight() * scale);
            sprite.setOriginCenter();
        }
        this.frameCount = frameCount;
        this.duration = duration;
        this.size.x = spriteArray.first().getWidth();
        this.size.y = spriteArray.first().getHeight();
        currentTime = 0;
        posOffset = new Vector2(0,0);
    }

    public AnimatedSprite(String baseName, int frameCount, float duration, float scale, Vector2 posOffset)
    {
        this(baseName, frameCount, duration, scale);
        this.posOffset = posOffset;
    }

    public void update(float delta) {
        currentTime += delta;
        if (currentTime > duration)
            currentTime = 0;
        currentFrame = (int) (currentTime / (duration / frameCount));
    }

    public void draw(Batch batch, Vector2 pos, boolean flipX, boolean flipY, boolean reverse, float direction) {
        if (reverse)
            currentSprite = spriteArray.get(frameCount - currentFrame - 1);
        else
            currentSprite = spriteArray.get(currentFrame);

        currentSprite.setRotation(direction);
        currentSprite.setFlip(flipX, flipY);
        currentSprite.setPosition(pos.x + posOffset.x, pos.y + posOffset.y);
        currentSprite.draw(batch);
    }

}
