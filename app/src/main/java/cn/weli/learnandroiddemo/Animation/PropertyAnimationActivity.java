package cn.weli.learnandroiddemo.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import cn.weli.learnandroiddemo.R;

public class PropertyAnimationActivity extends AppCompatActivity {

    private LinearLayout mContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initView();
        //添加MyanimationView组件
        mContainer.addView(new MyanimationView(this));

    }


    private void initView() {
       mContainer = findViewById(R.id.container);
    }
}
