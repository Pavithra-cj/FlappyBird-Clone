package lk.itzcorpio.android.games.flappybird;

public class BgImage {

    private int img_x_bg;
    private int img_y_bg;
    private int bgSpeed;

    public BgImage() {

        img_x_bg = 0;
        img_y_bg = 0;
        bgSpeed = 4;

    }

    public int getImg_x_bg() {
        return img_x_bg;
    }

    public void setImg_x_bg(int img_x_bg) {
        this.img_x_bg = img_x_bg;
    }

    public int getImg_y_bg() {
        return img_y_bg;
    }

    public void setImg_y_bg(int img_y_bg) {
        this.img_y_bg = img_y_bg;
    }

    public int velocity(){
        return bgSpeed;
    }

}
