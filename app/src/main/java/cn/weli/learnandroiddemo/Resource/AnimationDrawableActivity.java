package cn.weli.learnandroiddemo.Resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import cn.weli.learnandroiddemo.R;

public class AnimationDrawableActivity extends AppCompatActivity {

    private ImageView mImg;
    private Animation mAnimation;
    private Button mBtnStartAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);
        mImg = findViewById(R.id.anim_image);
        //加载动画资源
        mAnimation = AnimationUtils.loadAnimation(this,R.anim.my_anim_1);
        //设置动画结束后保留结束状态
        mAnimation.setFillAfter(true);
        mBtnStartAnim =findViewById(R.id.start_anim);
        mBtnStartAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImg.startAnimation(mAnimation);
            }
        });
    }
}
