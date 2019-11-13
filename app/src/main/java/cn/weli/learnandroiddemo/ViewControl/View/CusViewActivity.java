package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import cn.weli.learnandroiddemo.R;

public class CusViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_view);

//        LinearLayout root = findViewById(R.id.root);
        //创建DrawView组件
//        DrawView drawView = new DrawView(this);
//
//        drawView.setMinimumWidth(300);
//        drawView.setMinimumHeight(500);
//        root.addView(drawView);
    }
}
