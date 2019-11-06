package cn.weli.learnandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.DataStorage.DataStoreMainActivity;
import cn.weli.learnandroiddemo.FourMajorComponents.FourMainActivity;
import cn.weli.learnandroiddemo.ViewControl.ViewActivity;

public class RealMainActivity extends AppCompatActivity {

    private Button mBtnFour;
    private Button mStore;
    private Button mViewCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_main);
        mStore = findViewById(R.id.store);
        mBtnFour = findViewById(R.id.four_comp);
        mViewCon = findViewById(R.id.view_control);
        mBtnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, FourMainActivity.class);
                startActivity(intent);
            }
        });
        mStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, DataStoreMainActivity.class);
                startActivity(intent);
            }
        });
        mViewCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
