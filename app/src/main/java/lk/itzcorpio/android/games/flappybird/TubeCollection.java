package lk.itzcorpio.android.games.flappybird;

import java.util.Random;

public class TubeCollection {

    private int xTube;
    private int upTubeCollection_Y;
    private Random random;

    public TubeCollection(int xTube, int upTubeCollection_Y) {
        this.xTube = xTube;
        this.upTubeCollection_Y = upTubeCollection_Y;
        random = new Random();
    }

    public int getUpTubeCollection_Y(){
        return upTubeCollection_Y;
    }

    public int getXTube() {
        return xTube;
    }

    public int getUpTube_Y(){
        return upTubeCollection_Y - AppHolder.getBitmapControl().getTubeHeight();
    }

    public int getDownTube_Y(){
        return upTubeCollection_Y + AppHolder.tubeGap;
    }

    public void setXtube(int xTube)
    {
        this.xTube = xTube;
    }

    public void setUpTubeCollection_Y(int upTubeCollection_Y) {
        this.upTubeCollection_Y = upTubeCollection_Y;
    }

}
