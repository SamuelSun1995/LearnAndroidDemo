package cn.weli.learnandroiddemo.ViewControl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;
import cn.weli.learnandroiddemo.ViewControl.Fragment.DynamicFragmentActivity;
import cn.weli.learnandroiddemo.ViewControl.Fragment.StaticFragmentActivity;
import cn.weli.learnandroiddemo.ViewControl.ListView.ListViewActivity;
import cn.weli.learnandroiddemo.ViewControl.RecyleView.RecyleViewActivity;
import cn.weli.learnandroiddemo.ViewControl.SurfaceView.SurfaceViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ClockViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.CusViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.TextViewActivity;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.ViewPageActivity1;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.ViewPageActivity2;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.ViewPageActivity3;
import cn.weli.learnandroiddemo.ViewControl.WebView.WebViewActivity;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnLl;
    private Button mBtnTL;
    private Button mBtnFl;
    private Button mBtnAl;
    private Button mBtnCl;

    private Button mBtnListView;
    private Button mBtnRecyleView;
    private Button mBtnViewPage;
    private Button mBtnViewPage2;
    private Button mBtnViewPage3;
    private Button mBtnWebView;
    private Button mBtnSurfaceView;
    private Button mBtnFragment;
    private Button mBtnDynFragment;

    private Button mBtnCusView;
    private Button mBtnBaseView;
    private Button mBtnClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        bindView();
        setListener();
    }

    public void bindView() {
        mBtnLl = findViewById(R.id.linear_layout);
        mBtnTL = findViewById(R.id.table_layout);
        mBtnFl = findViewById(R.id.fram_layout);
        mBtnAl = findViewById(R.id.absolute_layout);
        mBtnCl = findViewById(R.id.constraint_layout);

        mBtnListView = findViewById(R.id.btn_list);
        mBtnRecyleView = findViewById(R.id.btn_recyleview);
        mBtnViewPage = findViewById(R.id.btn_viewpage);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnSurfaceView = findViewById(R.id.btn_surfaceview);
        mBtnFragment = findViewById(R.id.static_fragment);
        mBtnDynFragment = findViewById(R.id.dynamic_fragment);
        mBtnViewPage2 = findViewById(R.id.btn_viewpage2);
        mBtnViewPage3 = findViewById(R.id.btn_viewpage3);

        mBtnCusView = findViewById(R.id.cus_view);
        mBtnBaseView = findViewById(R.id.btn_baseview);

        mBtnClock = findViewById(R.id.btn_clockview);



    }

    public void setListener() {
        mBtnLl.setOnClickListener(this);
        mBtnTL.setOnClickListener(this);
        mBtnFl.setOnClickListener(this);
        mBtnAl.setOnClickListener(this);
        mBtnCl.setOnClickListener(this);
        mBtnBaseView.setOnClickListener(this);
        mBtnListView.setOnClickListener(this);
        mBtnRecyleView.setOnClickListener(this);
        mBtnViewPage.setOnClickListener(this);
        mBtnViewPage2.setOnClickListener(this);
        mBtnViewPage3.setOnClickListener(this);
        mBtnWebView.setOnClickListener(this);
        mBtnSurfaceView.setOnClickListener(this);

        mBtnFragment.setOnClickListener(this);
        mBtnDynFragment.setOnClickListener(this);
        mBtnCusView.setOnClickListener(this);
        mBtnClock.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout:
                Intent intent_l = new Intent(ViewActivity.this, LinnearLayoutActivity.class);
                startActivity(intent_l);
                break;
            case R.id.table_layout:
                Intent intent_t = new Intent(ViewActivity.this, TableLayoutActivity.class);
                startActivity(intent_t);
                break;
            case R.id.fram_layout:
                Intent intent_f = new Intent(ViewActivity.this, FramLayoutActivity.class);
                startActivity(intent_f);
                break;
            case R.id.absolute_layout:
                Toast.makeText(ViewActivity.this, "此方法已过时！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.constraint_layout:
                Intent intent_c = new Intent(ViewActivity.this, ConstraintLayoutActivity.class);
                startActivity(intent_c);
                break;

            case R.id.btn_list:
                Intent intent_list = new Intent(ViewActivity.this, ListViewActivity.class);
                startActivity(intent_list);
                break;
            case R.id.btn_recyleview:
                Intent intent_recyle = new Intent(ViewActivity.this, RecyleViewActivity.class);
                startActivity(intent_recyle);
                break;
            case R.id.btn_viewpage:
                Intent intent_viewpage = new Intent(ViewActivity.this, ViewPageActivity1.class);
                startActivity(intent_viewpage);
                break;
            case R.id.btn_viewpage2:
                Intent intent_viewpage2 = new Intent(ViewActivity.this, ViewPageActivity2.class);
                startActivity(intent_viewpage2);
                break;
            case R.id.btn_viewpage3:
                Intent intent_viewpage3 = new Intent(ViewActivity.this, ViewPageActivity3.class);
                startActivity(intent_viewpage3);
                break;

            case R.id.static_fragment:
                Intent intent_fragment = new Intent(ViewActivity.this, StaticFragmentActivity.class);
                startActivity(intent_fragment);
                break;
            case R.id.dynamic_fragment:
                Intent intent_dynamic_fragment = new Intent(ViewActivity.this, DynamicFragmentActivity.class);
                startActivity(intent_dynamic_fragment);
                break;
            case R.id.btn_webview:
                Intent intent_webview = new Intent(ViewActivity.this, WebViewActivity.class);
                startActivity(intent_webview);
                break;
            case R.id.btn_surfaceview:
                Intent intent_surfaceview = new Intent(ViewActivity.this, SurfaceViewActivity.class);
                startActivity(intent_surfaceview);
                break;

            case R.id.cus_view:
                Intent intent_cusView = new Intent(ViewActivity.this, CusViewActivity.class);
                startActivity(intent_cusView);
                break;
            case R.id.btn_baseview:
                Intent intent_baseview = new Intent(ViewActivity.this, TextViewActivity.class);
                startActivity(intent_baseview);
                break;

            case R.id.btn_clockview:
                Intent intent_clock = new Intent(ViewActivity.this, ClockViewActivity.class);
                startActivity(intent_clock);
                break;

        }
    }
}
