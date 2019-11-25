package cn.weli.learnandroiddemo.Net.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import cn.weli.learnandroiddemo.Net.MyObject;
import cn.weli.learnandroiddemo.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view2);
        mWebView= findViewById(R.id.ok_webview);
        //这边为了简化编程，加载本地的asset的html，也可以加载远程的html
        mWebView.loadUrl("file:////android_asset/test.html");
        //获取webView的设置对象
        WebSettings webSettings = mWebView.getSettings();
        //开启JavaScript调用
        webSettings.setJavaScriptEnabled(true);
        //将MyObject对象暴露给JavaScript脚本
        //这样text.html页面中的JavaScript可以通过myObj的方法
        mWebView.addJavascriptInterface(new MyObject(this),"myObj");
    }
}
