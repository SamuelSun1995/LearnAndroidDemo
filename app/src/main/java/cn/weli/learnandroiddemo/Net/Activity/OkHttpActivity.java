package cn.weli.learnandroiddemo.Net.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.weli.learnandroiddemo.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    private TextView response;
    private Button mBtnOk;
    private OkHttpClient mOkHttpClient;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        initView();
        onClick();
    }


    private void initView() {
        response = findViewById(R.id.response);
        mBtnOk = findViewById(R.id.btn_start_ok);
    }

    private void onClick() {
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建默认的okhttpclient
                // mOkHttpClient = OkHttpClient()
                Map<String, List<Cookie>> cookieStore = new HashMap<>();
                mOkHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(url.host(), cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(url.host());
                        return cookies == null ? new ArrayList<>() : cookies;
                    }
                }).build();
            }

            public void accessSecret(View source) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url ="http://192.168.1.88:8888/foo/secret.jsp";
                        //创建请求
                        Request request = new Request.Builder().url(url).build();   //1
                        Call call = mOkHttpClient.newCall(request);
                        try {
                            Response response = call.execute(); //2
                            Message msg =new Message();
                            msg.what = 0x123;
                            msg.obj = response.body().string().trim();
                            mHandler.sendMessage(msg);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            public void showLogin(View source){

                //加载登录页面
            View login = getLayoutInflater().inflate(R.layout.okhttp_login,null);
            //使用对话框提供用户登录系统
                new AlertDialog.Builder(OkHttpActivity.this).setTitle("登录系统").setView(login).setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      //获取用户输入的用户名、密码
                      String name = ((EditText)login.findViewById(R.id.ed_username)).getText().toString();
                      String pass = ((EditText)login.findViewById(R.id.ed_password)).getText().toString();
                      String url ="http://192.168.1.88:8888/foo/secret.jsp";

                        FormBody body = new FormBody.Builder().add("name",name).add("pass",pass).build();   // 3
                        Request request = new Request.Builder().url(url).post(body).build();    // 4
                        Call call = mOkHttpClient.newCall(request);
                        call.enqueue(new Callback() {           // 5
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {

                            }
                        });



                    }
                });

            }


        });


    }


}
