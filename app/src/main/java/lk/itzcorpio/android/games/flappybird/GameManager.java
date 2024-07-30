package lk.itzcorpio.android.games.flappybird;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

import lk.itzcorpio.android.games.flappybird.Activity.GameOverActivity;

public class GameManager {

    BgImage bgImage;
    FlyingBird flyingBird;
    static int gameState;
    ArrayList<TubeCollection> tubeCollection;
    Random random;
    int scoreCount;
    int winningTube;
    Paint designPaint;

    public GameManager() {

        bgImage = new BgImage();
        flyingBird = new FlyingBird();
        gameState = 0;
        tubeCollection = new ArrayList<>();
        random = new Random();
        generateTubeObject();
        initScore();

    }

    public void initScore()
    {
        scoreCount = 0;
        winningTube = 0;
        designPaint = new Paint();
        designPaint.setColor(Color.YELLOW);
        designPaint.setTextSize(250);
        designPaint.setStyle(Paint.Style.FILL);
        designPaint.setFakeBoldText(true);
        designPaint.setShadowLayer(5.0f, 20.0f, 20.0f, Color.BLACK);
    }

    public void generateTubeObject()
    {
        for (int i = 0; i < AppHolder.tubeGap; i++)
        {
            int xTube = AppHolder.SCRN_WIDTH_X + i * AppHolder.tubeDistance;
            int upTubeCollectionY = AppHolder.minimumTubeCollection_Y;
            random.nextInt(AppHolder.maximumTubeCollection_Y - AppHolder.minimumTubeCollection_Y + 1);
            TubeCollection tubeCollections = new TubeCollection(xTube, upTubeCollectionY);
            tubeCollection.add(tubeCollections);
        }
    }

    public void scrollingTube(Canvas can)
    {
        if (gameState == 1)
        {
            if (tubeCollection.get(winningTube).getXTube() < flyingBird.getBirdX() - AppHolder.getBitmapControl().getTubeWidth())
            {
                scoreCount++;
                winningTube++;
                if (winningTube > AppHolder.tube_numbers - 1) {
                    winningTube = 0;
                }
            }
            for (int i = 0; i < AppHolder.tube_numbers; i++)
            {
                if (tubeCollection.get(i).getXTube() < -AppHolder.getBitmapControl().getTubeWidth())
                {
                    tubeCollection.get(i).setXtube(tubeCollection.get(i).getXTube()
                            +AppHolder.tube_numbers*AppHolder.tubeDistance);
                    int upTubeCollectionY = AppHolder.minimumTubeCollection_Y + random.nextInt(AppHolder.maximumTubeCollection_Y - AppHolder.minimumTubeCollection_Y + 1);
                    tubeCollection.get(i).setUpTubeCollection_Y(upTubeCollectionY);
                }
                tubeCollection.get(i).setXtube(tubeCollection.get(i).getXTube() - AppHolder.tubeVelocity);
                can.drawBitmap(AppHolder.getBitmapControl().getUpTube(), tubeCollection.get(i).getXTube(), tubeCollection.get(i).getUpTube_Y(), null);
                can.drawBitmap(AppHolder.getBitmapControl().getDownTube(), tubeCollection.get(i).getXTube(), tubeCollection.get(i).getDownTube_Y(), null);
            }
            can.drawText("" + scoreCount, 620, 400, designPaint);
        }
    }

    public void birdAnimation(Canvas canvas) {
        if (gameState == 1)
        {
            if (tubeCollection.get(winningTube).getXTube() < flyingBird.getBirdX() + AppHolder.getBitmapControl().getBirdWidth()
                    && (tubeCollection.get(winningTube).getUpTubeCollection_Y() > flyingBird.getBirdY()
                    || tubeCollection.get(winningTube).getDownTube_Y() < (flyingBird.getBirdY() + AppHolder.getBitmapControl().getBirdHeight())))
            {
                gameState = 2;
                Context mContext = AppHolder.gameActivityContext;
                Intent intent = new Intent(mContext, GameOverActivity.class);
                intent.putExtra("Score", scoreCount);
                mContext.startActivity(intent);
                ((Activity)mContext).finish();
            }
            if (flyingBird.getBirdY() <(AppHolder.SCRN_HEIGHT_Y -AppHolder.getBitmapControl().getBirdHeight()) || flyingBird.getVelocity()<0)
            {
                flyingBird.setVelocity(flyingBird.getVelocity() + AppHolder.gravityPull);
                flyingBird.setBirdY(flyingBird.getBirdY() + flyingBird.getVelocity());
            }
        }
        int currentFrame = flyingBird.getCurrentFrames();
        canvas.drawBitmap(AppHolder.getBitmapControl().getBird(currentFrame), flyingBird.getBirdX(), flyingBird.getBirdY(), null);
        currentFrame++;
        if (currentFrame > FlyingBird.maximumFrames) {
            currentFrame = 0;
        }
        flyingBird.setCurrentFrames(currentFrame);
    }

    public void backgroundAnimation(Canvas canvas) {
        bgImage.setImg_x_bg(bgImage.getImg_x_bg() - bgImage.velocity());
        if (bgImage.getImg_x_bg() < -AppHolder.getBitmapControl().getBackgroundWidth()) {
            bgImage.setImg_x_bg(0);
        }

        canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getImg_x_bg(), bgImage.getImg_y_bg(), null);

        if (bgImage.getImg_x_bg() <- (AppHolder.getBitmapControl().getBackgroundWidth() - AppHolder.SCRN_WIDTH_X))
        {
            canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getImg_x_bg() + AppHolder.getBitmapControl().getBackgroundWidth(), bgImage.getImg_y_bg(), null);
        }

    }

}
