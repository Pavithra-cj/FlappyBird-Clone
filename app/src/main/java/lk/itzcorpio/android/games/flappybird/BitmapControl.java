package lk.itzcorpio.android.games.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapControl {

    Bitmap background;
    Bitmap[] FlyingBird;
    Bitmap upTube;
    Bitmap downTube;

    public BitmapControl(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background1);
        background = imageScale(background);
        FlyingBird = new Bitmap[3];
        FlyingBird[0] = BitmapFactory.decodeResource(res, R.drawable.bird1);
        FlyingBird[1] = BitmapFactory.decodeResource(res, R.drawable.bird2);
        FlyingBird[2] = BitmapFactory.decodeResource(res, R.drawable.bird3);
        upTube = BitmapFactory.decodeResource(res, R.drawable.up_tube);
        downTube = BitmapFactory.decodeResource(res, R.drawable.down_tube);
    }

    public Bitmap getUpTube() {
        return upTube;
    }

    public Bitmap getDownTube() {
        return downTube;
    }

    public int getTubeHeight() {
        return upTube.getHeight();
    }

    public int getTubeWidth() {
        return upTube.getWidth();
    }

    public Bitmap getBird(int frame) {
        return FlyingBird[frame];
    }

    public int getBirdHeight() {
        return FlyingBird[0].getHeight();
    }

    public int getBirdWidth() {
        return FlyingBird[0].getWidth();
    }

    public Bitmap getBackground() {
        return background;
    }

    public int getBackgroundHeight() {
        return background.getHeight();
    }

    public int getBackgroundWidth() {
        return background.getWidth();
    }

    public Bitmap imageScale (Bitmap bitmap){
        float width_height_ratio = getBackgroundWidth() / getBackgroundHeight();
        int bgScaleWidth = (int) width_height_ratio * AppHolder.SCRN_WIDTH_X;
        return Bitmap.createScaledBitmap(bitmap, bgScaleWidth, AppHolder.SCRN_HEIGHT_Y, false);
    }

}
