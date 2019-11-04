package cn.weli.learnandroiddemo.ActivityDemo.SartMode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.weli.learnandroiddemo.ActivityDemo.ActivityDto;
import cn.weli.learnandroiddemo.R;

public class SingleInstanceActivity extends AppCompatActivity {

    private Button mStartSingleInstance;
    public int mCount = ActivityDto.getSingleInstanceCount()+1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
        mStartSingleInstance = findViewById(R.id.btn_start_singleInstance);
        mStartSingleInstance.setText("启动第："+mCount+"个普通A");
        mStartSingleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (mCount% 2 == 0) {
                    intent = new Intent(SingleInstanceActivity.this, EActivity.class);
                } else {
                    intent = new Intent(SingleInstanceActivity.this, SingleInstanceActivity.class);
                }
                ActivityDto.setSingleInstanceCount(mCount);
                startActivity(intent);
            }
        });
    }
}
