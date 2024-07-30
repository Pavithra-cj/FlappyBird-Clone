package lk.itzcorpio.android.games.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

public class MainThread extends Thread{

    SurfaceHolder surfaceHolder;
    long timeSpent;
    long kickOffTime;
    long WAIT = 31;
    boolean Running;
    private static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder) {

        this.surfaceHolder = surfaceHolder;
        Running = true;

    }

    public void run()
    {
        while (Running)
        {
            kickOffTime = SystemClock.uptimeMillis();
            canvas = null;
            try {
                synchronized (surfaceHolder)
                {
                    canvas = surfaceHolder.lockCanvas();
                    AppHolder.getGameManager().backgroundAnimation(canvas);
                    AppHolder.getGameManager().birdAnimation(canvas);
                    AppHolder.getGameManager().scrollingTube(canvas);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if (canvas != null)
                {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            timeSpent = SystemClock.uptimeMillis() - kickOffTime;
            if (timeSpent < WAIT) {
                try {
                    Thread.sleep(WAIT - timeSpent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isRunning() {
        return Running;
    }

    public void setIsRunning(boolean state) {
        Running = state;
    }

}
