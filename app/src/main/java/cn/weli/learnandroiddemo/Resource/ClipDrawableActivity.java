package cn.weli.learnandroiddemo.Resource;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import cn.weli.learnandroiddemo.R;

public class ClipDrawableActivity extends AppCompatActivity {

    private ImageView mClipImgae;
    private ClipDrawable mClipDrawable;
    private Timer mTimer;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0x1233:
                    //修改ClipDrawable的level值
                    mClipDrawable.setLevel(mClipDrawable.getLevel() + 200);
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_drawable);

        mClipImgae = findViewById(R.id.clip_imgae);

        mClipDrawable = (ClipDrawable) mClipImgae.getDrawable();


        //设置定时器
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x1233;
                //发送消息，通知修改clipdrawable对象的level值
                mHandler.sendMessage(msg);
                //取消定时器
                if (mClipDrawable.getLevel() >= 10000) {
                    mTimer.cancel();
                }
            }
        }, 0, 300);
    }
}
