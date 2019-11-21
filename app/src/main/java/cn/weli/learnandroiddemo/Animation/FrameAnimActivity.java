package cn.weli.learnandroiddemo.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import cn.weli.learnandroiddemo.R;

public class FrameAnimActivity extends AppCompatActivity {

    private Button mStart;
    private Button mStop;
    private ImageView mImageView;
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_view1);
        mStart = findViewById(R.id.start);
        mStop = findViewById(R.id.stop);
        mImageView = findViewById(R.id.img_anim);
        //获取annimationDrawable动画对象
         anim = (AnimationDrawable) mImageView.getBackground();
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.start();
            }
        });
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.stop();
            }
        });
    }
}
