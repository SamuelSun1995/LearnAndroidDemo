package cn.weli.learnandroiddemo.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.R;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBitmapFactory;

    private Button mImageDecoder;
    private Button mBtnCusView;
    private Button mBtnTweenAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation2);
        initView();
        setListener();
    }

    private void setListener() {
        mBitmapFactory.setOnClickListener(this);
        mImageDecoder.setOnClickListener(this);
        mBtnCusView.setOnClickListener(this);
        mBtnTweenAnim.setOnClickListener(this);
    }

    private void initView() {
        mBitmapFactory = findViewById(R.id.btn_bitmapfactory);
        mImageDecoder = findViewById(R.id.btn_image_decoder);
        mBtnCusView = findViewById(R.id.btn_cus_view);
                mBtnTweenAnim = findViewById(R.id.btn_tween_anim);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bitmapfactory:
                Intent intent_bitmapfactory = new Intent(this, BitmapFactoryActivity.class);
                startActivity(intent_bitmapfactory);
                break;
            case R.id.btn_image_decoder:
                Intent intent_imageDecoder = new Intent(this, ImageDecoderActivity.class);
                startActivity(intent_imageDecoder);
                break;
            case R.id.btn_cus_view:
                Intent intent_cus_view = new Intent(this, FrameAnimActivity.class);
                startActivity(intent_cus_view);
                break;
            case R.id.btn_tween_anim:
                Intent intent_tween_anim = new Intent(this,TweenAnimActivity.class);
                startActivity(intent_tween_anim);
                break;
            case R.id.btn_anim_pro:
                Intent btn_anim = new Intent(this,TweenAnimActivity.class);
                startActivity(btn_anim);
                break;

        }
    }
}
