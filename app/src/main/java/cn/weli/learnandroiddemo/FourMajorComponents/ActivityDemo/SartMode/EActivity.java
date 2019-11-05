package cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo.SartMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo.ActivityDto;
import cn.weli.learnandroiddemo.R;

public class EActivity extends AppCompatActivity {

    private Button mSingleTask;

    public static final String TAG = "singleInstance";
    public int mNum = ActivityDto.getSingleInstance() + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);
        Log.i(TAG, "第：" + mNum + "个Activity");
        Log.i(TAG, "onCreate：*************:" + mNum);
        ActivityDto.setSingleInstance(mNum);
        mSingleTask = findViewById(R.id.singleTask_mode);
        mSingleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent：*************:" + mNum);
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
