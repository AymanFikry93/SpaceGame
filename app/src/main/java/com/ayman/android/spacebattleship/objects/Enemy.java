package com.ayman.android.spacebattleship.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.ayman.android.spacebattleship.R;

import java.util.Random;

/**
 * Created by ayman on 2018-04-19.
 */

public class Enemy extends CollideGameObject{
    public Enemy(Context context) {
        super(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy));
    }

    public void update(int playerSpeed) {
        setX(getX() - playerSpeed - getSpeed());
        if (getX() < getMinX() - getBitmap().getWidth()) {
            setupPlacementAndSpeed();
        }
        super.update(playerSpeed);
    }

    @Override
    public void setupPlacementAndSpeed() {
        clearMissed();
        clearCollided();
        Random generator = new Random();
        setSpeed(generator.nextInt(10) + 10);
        setX(getMaxX());
        setY(generator.nextInt(getMaxY()));
    }
}