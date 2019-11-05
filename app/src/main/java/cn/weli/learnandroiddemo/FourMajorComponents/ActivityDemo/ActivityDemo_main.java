package cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo.SartMode.BActivity;
import cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo.SartMode.CActivity;
import cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo.SartMode.DActivity;
import cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo.SartMode.EActivity;
import cn.weli.learnandroiddemo.R;

public class ActivityDemo_main extends AppCompatActivity implements View.OnClickListener {

    private Button mStandard;
    private Button mSingleTop;
    private Button mSingleTask;
    private Button mSingleInstance;

    public static final String TAG = "startDemo";
    public int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_main);
        bindView();
        setListener();
    }

    public void bindView() {
        mStandard = findViewById(R.id.standard_mode);
        mSingleTop = findViewById(R.id.singleTop_mode);
        mSingleTask = findViewById(R.id.singleTask_mode);
        mSingleInstance = findViewById(R.id.singInstance_mode);
    }

    public void setListener() {
        mStandard.setOnClickListener(this);
        mSingleTop.setOnClickListener(this);
        mSingleTask.setOnClickListener(this);
        mSingleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.standard_mode:
                Bundle bundle = new Bundle();
                bundle.putString("mode","标准模式");
                Intent intent_b = new Intent(this, BActivity.class);
                intent_b.putExtras(bundle);
                startActivity(intent_b);
                break;
            case R.id.singleTop_mode:
                Intent intent_c = new Intent(this, CActivity.class);
                startActivity(intent_c);
                break;
            case R.id.singleTask_mode:
                Intent intent_d = new Intent(this, DActivity.class);
                startActivity(intent_d);
                break;
            case R.id.singInstance_mode:
                Intent intent_e = new Intent(this, EActivity.class);
                startActivity(intent_e);
                break;
        }
    }

}
