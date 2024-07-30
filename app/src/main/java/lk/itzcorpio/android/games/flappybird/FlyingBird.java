package lk.itzcorpio.android.games.flappybird;

public class FlyingBird {

    private int birdX;
    private int birdY;
    private int currentFrames;
    private int velocity;
    public static int maximumFrames;

    public FlyingBird() {
        birdX = AppHolder.SCRN_WIDTH_X/2 - AppHolder.getBitmapControl().getBirdWidth()/2;
        birdY = AppHolder.SCRN_HEIGHT_Y/2 - AppHolder.getBitmapControl().getBirdHeight()/2;
        currentFrames = 0;
        maximumFrames = 2;
    }

    public int getBirdX() {
        return birdX;
    }

    public void setBirdX(int birdX) {
        this.birdX = birdX;
    }

    public int getBirdY() {
        return birdY;
    }

    public void setBirdY(int birdY) {
        this.birdY = birdY;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getCurrentFrames() {
        return currentFrames;
    }

    public void setCurrentFrames(int currentFrames) {
        this.currentFrames = currentFrames;
    }

}
