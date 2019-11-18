package cn.weli.learnandroiddemo.Resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.weli.learnandroiddemo.R;

public class StyleAndThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置主题
        setTheme(R.style.SunTheme);
        setContentView(R.layout.activity_style_and_theme);
    }
}
