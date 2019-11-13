package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import cn.weli.learnandroiddemo.R;

public class ClockViewActivity extends AppCompatActivity {

    private Chronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_view);
        mChronometer = findViewById(R.id.numTime);
        mChronometer.setBase(0);
        mChronometer.setFormat("mm:ss");
        mChronometer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mChronometer.stop();
    }
}
