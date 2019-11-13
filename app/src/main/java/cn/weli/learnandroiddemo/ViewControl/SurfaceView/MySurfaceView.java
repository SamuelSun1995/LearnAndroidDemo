package cn.weli.learnandroiddemo.ViewControl.SurfaceView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private SurfaceHolder mHolder;
    private Canvas mCanvas; //用于绘图的Canvas
    private boolean mIsDrawing;  //子线程

    public static final int TIME_IN_FRAME = 30;

    private Path mPath;
    private int x, y;

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        mPath = new Path();

        while (mIsDrawing) {

            //取的更新的之前的时间
            long startTime = System.currentTimeMillis();

            //加上线程安全锁
            synchronized (mHolder) {
                //拿到当前画布，然后锁定
                draw();
            }

            long endTime = System.currentTimeMillis();

            //计算出一次更新的毫秒数
            int diffTime = (int) (endTime - startTime);
            //确保每次更新时间为30
            while (diffTime < +TIME_IN_FRAME) {
                diffTime = (int) (System.currentTimeMillis() - startTime);
                //线程等待
                Thread.yield();
            }
        }

    }

    public void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            x += 1;
            y = (int) (100 * Math.sin(x * 2 * Math.PI / 180) + 400);
            mPath.lineTo(x,y);

        } catch (Exception e) {
        } finally {
            if (mCanvas != null) {
                mHolder.unlockCanvasAndPost(mCanvas);     //保证每次都将绘图的内容提交
            }
        }
    }

    public void initView() {
        mHolder = getHolder();  //获取surfaceholder对象
        mHolder.addCallback(this);  //注册SurfaceHolder回调对象
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }
}
