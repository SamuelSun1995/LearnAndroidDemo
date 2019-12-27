package cn.weli.learnandroiddemo.ViewControl.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import cn.weli.learnandroiddemo.R;

public class WebViewActivity extends AppCompatActivity {

    public static final String TAG = "WebViewActivity";

    private WebView mWebView;
    private ConstraintLayout mConstraintLayout;
    private Button mBtnBack;
    private Button mBtnForward;
    private Button mBtnReload;  //刷新

    private WebChromeClient mWebChromeClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        bindView();
        //加载网站
        loadWeb();
        //点击事件
        onClick();
        //setDownloadListener
        setDownloadListener();
        //初始化webClient
        initWebChromClient();

    }

    private void initWebChromClient() {
        mWebChromeClient = new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        };
    }

    public void bindView() {
        mWebView = findViewById(R.id.webview);
        mConstraintLayout = findViewById(R.id.webview_lay);
        mBtnBack = findViewById(R.id.back);
        mBtnForward = findViewById(R.id.forward);
        mBtnReload = findViewById(R.id.reload);

    }

    public void loadWeb() {
        //避免弹出浏览器
        mWebView.setWebViewClient(new WebViewClient(){

            //重定向URL请求，返回true表示拦截此url，返回false表示不拦截此url。
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //作用1：重定向url
                if(url.startsWith("weixin://")){
                    url = url.replace("weixin://","http://");
                    mWebView.loadUrl(url);
                }
                //作用2：在本页的webview打开，防止外部浏览器打开此链接
                view.loadUrl(url);
                return true;
            }
        });
        //方式一：加载一个网页
        mWebView.loadUrl("http://mini.eastday.com/mobile/191129115551002.html");

        //方式二：加载应用资源文件内的网页
//        mWebView.loadUrl("file:///android_asset/test.html");

        //方式三：加载一段代码
//        mWebView.loadData(String data,String mimeType, String encoding);
//        String body = "这里有个img标签，地址为相对路径";
//        mWebView.loadDataWithBaseURL("http://www.baidu.com", body, "text/html", "utf-8",null);
    }

    public void onClick() {
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //webview是否可以后退
                boolean canGoBack = mWebView.canGoBack();
                Log.i(TAG, "canGoBack: " + canGoBack);
                //webview是否可以后退
                mWebView.goBack();
            }
        });

        mBtnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //WebView是否可以前进
                boolean canGoForward = mWebView.canGoForward();
                Log.i(TAG, "canGoForward: " + canGoForward);
                //WebView前进
                mWebView.goForward();
            }
        });

        mBtnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.reload();
            }
        });

    }

    public void setDownloadListener() {
        /**
         * 当下载文件时打开系统自带的浏览器进行下载，当然也可以对捕获到的url进行处理下载。
         */
        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Uri uri =Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        //恢复webview的状态（不靠谱）
        mWebView.resumeTimers();
        //激活webView的状态，能正常加载网页
        mWebView.onResume();
        Log.i(TAG, "onResume: *********************************webView");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //当页面被失去焦点被切换到后台不可见状态，需要执行onPause
        //通过onPause动作通知内核暂停所有的动作，比如DOM的解析、plugin的执行、JavaScript执行。
        mWebView.onPause();

        //当应用程序(存在webview)被切换到后台时，这个方法不仅仅针对当前的webview而是全局的全应用程序的webview
        //它会暂停所有webview的layout，parsing，javascripttimer。降低CPU功耗。（不靠谱）
        mWebView.pauseTimers();
        Log.i(TAG, "onPause: *********************************webView");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mConstraintLayout.removeView(mWebView);
        mWebView.destroy();
        Log.i(TAG, "onDestroy: *********************************webView");
    }
}
