package cn.weli.learnandroiddemo.Event.View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import cn.weli.learnandroiddemo.Event.Listener.PlaneActivity;
import cn.weli.learnandroiddemo.R;

public class PlaneView extends View {

    public float currentX;
    public float currentY;

    public float bulletLeftX;
    public float bulletLeftY;
    public float bulletRightX;
    public float bulletRightY;

    private int index;

    private Bitmap plane1;
    private Bitmap plane2;
    private Bitmap bullet;

    private int mPlaneWidth;
    private int mPlaneHeight;
    private BitmapFactory.Options options;

    //创建画笔
    private Paint p = new Paint();

    public PlaneView(Context context) {
        super(context);
        initView(context);

    }

    public PlaneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将位图缩小一半
        Matrix matrix = new Matrix();
        matrix.postScale(0.4f, 0.4f);
        //绘制飞机
//        canvas.drawBitmap(index % 2 == 0 ? plane1 : plane2, matrix, p);
        canvas.drawBitmap(index % 2 == 0 ? plane1 : plane2, currentX, currentY, p);


        bulletLeftY = bulletRightY = plane1.getHeight()/2;

        bulletLeftX=currentX-plane1.getWidth()/2;
        bulletRightX=currentX+plane1.getWidth()/2;

        canvas.drawBitmap(bullet, bulletLeftX, bulletLeftY, p);
        canvas.drawBitmap(bullet, bulletRightX, bulletRightY, p);
//        postInvalidateDelayed(1000);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        mPlaneWidth = plane1.getWidth();
        mPlaneHeight = plane1.getHeight();

        currentX = event.getX() - mPlaneWidth / 2;
        currentY = event.getY() - mPlaneHeight / 2;
        invalidate();
        return true;
    }

    private void initView(final Context context) {
        //定义飞机图片
        plane1 = compressBitmap(context.getResources(), R.drawable.plane1, 3);
        plane2 = compressBitmap(context.getResources(), R.drawable.plane2, 3);
        //子弹图片
        bullet = compressBitmap(context.getResources(), R.drawable.bullet, 4);
//        plane2.compress()
        //启动定时器来切换飞机图片实现动画效果
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                index++;
                ((PlaneActivity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        invalidate();
                    }
                });
            }
        }, 1000L, 100L);
        //获得焦点
        setFocusable(true);

    }


    //缩小图片
    public Bitmap compressBitmap(Resources resources, int id, int inSampleSize) {

        options = new BitmapFactory.Options();
        //设置为true,表示解析Bitmap对象，该对象不占内存
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, id, options);
        //设置缩放比例
        options.inSampleSize = inSampleSize;
        //设置为false,解析Bitmap对象加入到内存中
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, id, options);
    }

    public int computeScale(BitmapFactory.Options options) {
        int inSampleSize = 1;
        if (mPlaneWidth == 0 || mPlaneHeight == 0) {
            return inSampleSize;
        }

        int bitmapWidth = options.outWidth;
        int bitmapHeight = options.outHeight;

        if (bitmapWidth > mPlaneWidth || bitmapHeight > mPlaneHeight) {
            int widthScale = Math.round(bitmapWidth / mPlaneWidth);
            int heightScale = Math.round(bitmapHeight / mPlaneHeight);


            inSampleSize = widthScale < heightScale ? widthScale : heightScale;
        }
        return inSampleSize;

    }


}
