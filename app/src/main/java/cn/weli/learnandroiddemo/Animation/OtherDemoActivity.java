package cn.weli.learnandroiddemo.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.Net.Activity.NetActivity;
import cn.weli.learnandroiddemo.Net.Activity.OkHttpActivity;
import cn.weli.learnandroiddemo.Net.Activity.UrlActivity;
import cn.weli.learnandroiddemo.Net.Activity.WebViewActivity;
import cn.weli.learnandroiddemo.R;

public class OtherDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnNet;
    private Button mBtnUrl;
    private Button mBtnOk;
    private Button mBtnOkWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_demo);

        initView();
        setListener();

    }

    private void setListener() {
        mBtnNet.setOnClickListener(this);
        mBtnUrl.setOnClickListener(this);
        mBtnOk.setOnClickListener(this);
        mBtnOkWebView.setOnClickListener(this);
    }

    private void initView() {
         mBtnNet = findViewById(R.id.btn_net);

        mBtnUrl = findViewById(R.id.btn_net_url);
        mBtnOk = findViewById(R.id.btn_okhttp);
        mBtnOkWebView = findViewById(R.id.btn_ok_webview);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_net:
                Intent intent = new Intent(this, NetActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_net_url:
                Intent intent_url = new Intent(this, UrlActivity.class);
                startActivity(intent_url);
                break;
            case R.id.btn_okhttp:
                Intent intent_ok = new Intent(this, OkHttpActivity.class);
                startActivity(intent_ok);
                break;
            case R.id.btn_ok_webview:
                Intent intent_webview = new Intent(this, WebViewActivity.class);
                startActivity(intent_webview);
                break;

        }
    }
}
