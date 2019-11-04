package cn.weli.learnandroiddemo.ActivityDemo.SartMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.R;

public class SingleTaskActivity extends AppCompatActivity {

    private Button mStatrtSingleTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        mStatrtSingleTask = findViewById(R.id.btn_start_singleTask);
        mStatrtSingleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivity.this, DActivity.class);
                startActivity(intent);
            }
        });
    }
}
