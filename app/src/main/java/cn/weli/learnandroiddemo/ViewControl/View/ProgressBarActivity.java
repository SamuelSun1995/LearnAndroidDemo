package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

import java.lang.ref.WeakReference;

import cn.weli.learnandroiddemo.R;

public class ProgressBarActivity extends AppCompatActivity {


    private ProgressBar mProgressBar1;
    private ProgressBar mProgressBar2;

    private SeekBar mSeekbar1;
    private SeekBar mSeekbar2;

    private RatingBar mRating;

    private ImageView mImg;


    //该程序的模拟填充长度为100的数组
    private int[] data = new int[100];
    private int hasData = 0;
    //记录progressbar完成进度
    int status = 0;

    private static class MyHandler extends Handler {
        private WeakReference<ProgressBarActivity> activity;

        MyHandler(WeakReference<ProgressBarActivity> activity) {
            this.activity = activity;
        }

        //表明消息是由该程序发送
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 0x11) {
                activity.get().mProgressBar1.setProgress(activity.get().status);
                activity.get().mProgressBar2.setProgress(activity.get().status);
            }
        }
    }

    //创建一个负责更新的进度的handler
    MyHandler mHandler = new MyHandler(new WeakReference<ProgressBarActivity>(this));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        mProgressBar1 = findViewById(R.id.bar1);
        mProgressBar2 = findViewById(R.id.bar2);
        mSeekbar1 = findViewById(R.id.seekbar1);
        mSeekbar2 = findViewById(R.id.seekbar2);
        mImg =findViewById(R.id.image_cat);
        mRating =findViewById(R.id.rating);


        mSeekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //当拖动条的滑块位置发生改变是出发该方法
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mImg.setImageAlpha(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mImg.setImageAlpha((int) rating*255/6);
                }
            }
        });



        //启动线程来执行任务
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (status < 100) {
                    //获取耗时操作完成的百分比
                    status = doWork();
                    //发送消息
                    mHandler.sendEmptyMessage(0x11);
                }
            }
        }.start();

    }

    //模拟一个耗时操作
    public int doWork() {
        //为数组元素赋值
        data[hasData++] = (int) (Math.random() * 100);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
