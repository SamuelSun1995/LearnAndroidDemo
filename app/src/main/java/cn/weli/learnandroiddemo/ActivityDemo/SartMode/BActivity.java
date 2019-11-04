package cn.weli.learnandroiddemo.ActivityDemo.SartMode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.weli.learnandroiddemo.ActivityDemo.ActivityDto;
import cn.weli.learnandroiddemo.R;

public class BActivity extends AppCompatActivity {

    private Button mBtnMode;
    public static final String TAG = "standardMode";
    public int mNum = ActivityDto.getStandard_number() + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.i(TAG, "第：" + mNum + "个Activity");
        Log.i(TAG, "onCreate：*************:" + mNum);
        ActivityDto.setStandard_number(mNum);
//        Intent intent = getIntent();
//        String standard = intent.getStringExtra("mode");
        mBtnMode = findViewById(R.id.btn_mode);
        mBtnMode.setText("标准模式："+mNum);
        mBtnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, BActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart：*************:" + mNum);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume：*************:" + mNum);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause：*************:" + mNum);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop：*************:" + mNum);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart：*************:" + mNum);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy：*************:" + mNum);
    }

}
