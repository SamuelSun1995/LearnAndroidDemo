package cn.weli.learnandroiddemo.Event.Listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import cn.weli.learnandroiddemo.Event.View.PlaneView;
import cn.weli.learnandroiddemo.R;

public class PlaneActivity extends AppCompatActivity {

    //定义飞机的移动速度
    private int speed = 10;
    private PlaneView mPlaneView;
    private DisplayMetrics mDisplayMetrics;     //获取屏幕大小
    private WindowManager mWindowManager;
    private Display mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        initView();
        setContentView(R.layout.activity_plane);


    }


    public void initView() {

        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //创建PlaneView组件
        mPlaneView = new PlaneView(this);
        setContentView(mPlaneView);
        mPlaneView.setBackgroundResource(R.drawable.plane_background);
        //获得窗口管理器
        mWindowManager = getWindowManager();
        mDisplay = mWindowManager.getDefaultDisplay();
        mDisplayMetrics = new DisplayMetrics();
        //获得屏幕宽高
        mPlaneView.currentX = (mDisplayMetrics.widthPixels / 2);
        mPlaneView.currentY = (mDisplayMetrics.heightPixels - 200);
        mPlaneView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getX() < mDisplayMetrics.widthPixels / 8) {
                    mPlaneView.currentX -= speed;
                }
                if (event.getX() < mDisplayMetrics.widthPixels * 7 / 8) {
                    mPlaneView.currentX += speed;
                }
                if (event.getY() < mDisplayMetrics.heightPixels / 8) {
                    mPlaneView.currentY -= speed;
                }
                if (event.getY() < mDisplayMetrics.heightPixels * 7 / 8) {
                    mPlaneView.currentY += speed;
                }


                return true;
            }
        });


    }
}
