package cn.weli.learnandroiddemo.FourMajorComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo.ActivityDemo_main;
import cn.weli.learnandroiddemo.FourMajorComponents.BroadcastDemo.BroadcastMainActivity;
import cn.weli.learnandroiddemo.FourMajorComponents.ContentProviderDemo.ContentProviderActivity;
import cn.weli.learnandroiddemo.FourMajorComponents.ServiceDemo.ServiceMainActivity;
import cn.weli.learnandroiddemo.R;

public class FourMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mActivity;
    private Button mService;
    private Button mBroadcast;
    private Button mContentprovider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setListener();
    }

    public void bindView() {
        mActivity = findViewById(R.id.activity_test);
        mService = findViewById(R.id.service_test);
        mBroadcast = findViewById(R.id.broadcast_test);
        mContentprovider = findViewById(R.id.contentprovider_test);
    }

    public void setListener() {
        mActivity.setOnClickListener(this);
        mService.setOnClickListener(this);
        mBroadcast.setOnClickListener(this);
        mContentprovider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_test:
                Intent intent_a = new Intent(FourMainActivity.this, ActivityDemo_main.class);
                startActivity(intent_a);
                Toast.makeText(this,getString(R.string.enter_activity_test),Toast.LENGTH_SHORT).show();
                break;
            case R.id.service_test:
                Intent intent_s = new Intent(this, ServiceMainActivity.class);
                startActivity(intent_s);
                Toast.makeText(this,getString(R.string.enter_service_test),Toast.LENGTH_SHORT).show();
                break;
            case R.id.broadcast_test:
                Intent intent_b = new Intent(this, BroadcastMainActivity.class);
                startActivity(intent_b);
                Toast.makeText(this,getString(R.string.enter_broadcasst_test),Toast.LENGTH_SHORT).show();
                break;
            case R.id.contentprovider_test:
                Intent intent_c = new Intent(this, ContentProviderActivity.class);
                startActivity(intent_c);
                Toast.makeText(this,getString(R.string.enter_contentprovider_test),Toast.LENGTH_SHORT).show();
                break;




        }
    }
}
