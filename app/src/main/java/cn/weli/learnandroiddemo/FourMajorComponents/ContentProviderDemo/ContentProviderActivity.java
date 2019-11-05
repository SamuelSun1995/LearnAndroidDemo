package cn.weli.learnandroiddemo.FourMajorComponents.ContentProviderDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.weli.learnandroiddemo.R;

public class ContentProviderActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvContent;
    private Button mBtnImg;
    private Button mBtnPer;
    private Button mCus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        bingView();
        setListener();
    }

    public void bingView() {
        mTvContent = findViewById(R.id.tv_content);
        mBtnImg = findViewById(R.id.rec_photo);
        mBtnPer = findViewById(R.id.rec_com_pe);
        mCus = findViewById(R.id.rec_cus);
    }

    public void setListener(){
        mBtnImg.setOnClickListener(this);
        mBtnPer.setOnClickListener(this);
        mCus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rec_photo:
                //获取系统照片
                Intent intent = new Intent(this, ImageActivity.class);
                startActivity(intent);
                break;
            case R.id.rec_com_pe:
                //获取手机联系人
                break;
            case R.id.rec_cus:
                //获取自定义contentprovider的信息
                break;
        }
    }
}
