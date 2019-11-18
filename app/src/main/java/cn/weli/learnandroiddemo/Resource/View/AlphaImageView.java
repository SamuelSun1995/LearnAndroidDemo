package cn.weli.learnandroiddemo.Resource.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.Attributes;

import cn.weli.learnandroiddemo.R;

public class AlphaImageView extends AppCompatImageView {

    private Context mContext;

    //每隔多少秒透明度改变一次
    private final static int SPEED = 300;

    //图片透明度每次改变大小
    private int alphaDelta;
    //记录图片当前透明度
    private int curAlpha;
    private Timer mTimer;
    private Handler mHandler = new Handler() {
        private AlphaImageView mAlphaImageView;
        private WeakReference<AlphaImageView> mImageView;


        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void handleMessage(@NonNull Message msg) {
            mAlphaImageView = new AlphaImageView(mContext, null);

            mImageView = new WeakReference<AlphaImageView>(mAlphaImageView);
            switch (msg.what) {
                case 0x123:
                    //每次增加curAlpha的值
                    mImageView.get().curAlpha += mImageView.get().alphaDelta;

                    if (mImageView.get().curAlpha > 255) {
                        mImageView.get().curAlpha = 255;
                    }
                    //修改该ImageView的透明度
                    mImageView.get().setImageAlpha(mImageView.get().curAlpha);
                    break;
            }
        }
    };

    public AlphaImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AlphaImageView);
        //获取duration参数
        int duration = typedArray.getInt(R.styleable.AlphaImageView_duration, 1);
        //回收
        typedArray.recycle();
        //计算透明度每次改变的大小
        alphaDelta = 255 * SPEED / duration;
        mTimer = new Timer();
        //按固定间隔发送消息，改变图片的透明度
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x123;
                if (curAlpha >= 255) {
                    mTimer.cancel();
                } else {
                    mHandler.sendMessage(msg);
                }
            }
        }, 0L, SPEED);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas) {
        this.setImageAlpha(curAlpha);
        super.onDraw(canvas);
    }
}
