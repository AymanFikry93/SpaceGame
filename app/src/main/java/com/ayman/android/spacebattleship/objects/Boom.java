package com.ayman.android.spacebattleship.objects;

/**
 * Created by ayman on 2018-04-19.
 */


        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;

        import com.ayman.android.spacebattleship.R;

/**
 * Created by Belal on 6/15/2016.
 */
public class Boom extends CollideGameObject {

    public Boom(Context context) {
        super(BitmapFactory.decodeResource
                (context.getResources(), R.drawable.boom));
    }

    @Override
    public void setupPlacementAndSpeed() {
        setX(-500);
        setY(-500);
    }

    public void clearCollide() {
        setupPlacementAndSpeed();
    }

    public void setCollideAt(int x, int y) {
        setX(x);
        setY(y);
    }

}