package cn.weli.learnandroiddemo.Net.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import cn.weli.learnandroiddemo.Net.UrlConnManager;
import cn.weli.learnandroiddemo.R;

public class UrlActivity extends AppCompatActivity {

    private ImageView mUrlImg;
    private Button mBtnUrl;
    private Bitmap bitmap;

    private Button mBtnUrlConn;

    private Handler mHandler =new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0x123:
                    mUrlImg.setImageBitmap(bitmap);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        initView();
        onClick();

    }

    private void onClick() {
        mBtnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        //定义一个URL对象
                        try {
                            URL url = new URL("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=TUPIAN&step_word=&hs=0&pn=1&spn=0&di=54340&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2973069531%2C657782944&os=686666959%2C220536064&simid=3324719054%2C22587718&adpicid=0&lpn=0&ln=1387&fr=&fmq=1574648445300_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fpic44.nipic.com%2F20140723%2F18505720_094503373000_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3F8amcl00a_z%26e3Bip4s&gsm=&rpstart=0&rpnum=0&islist=&querylist=&force=undefined");
                            InputStream is = url.openStream();
                            //从InputStream中解析处图片
                            bitmap = BitmapFactory.decodeStream(is);
                            //发送消息显示图片
                            mHandler.sendEmptyMessage(0x123);
                            is.close();
                            //再次打开对应资源的输入流
                            is = url.openStream();
                            //打开手机文件对应的输出流
                            OutputStream os = openFileOutput("demo.jpg", Context.MODE_PRIVATE);
                            byte[] buff = new byte[1024];
                            int hasRead = -1;
                            //将URL对应的资源下载到本地
                            while((hasRead=is.read(buff))>0){

                                os.write(buff,0,hasRead);

                            }
                            is.close();
                            os.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }).start();
            }
        });


        mBtnUrlConn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UrlConnManager urlConnManager = new UrlConnManager();
                        urlConnManager.useHttpUrlConnectionPost("http://www.baidu.com");
                    }
                }).start();
            }
        });

    }

    private void initView() {
       mUrlImg = findViewById(R.id.url_image);
        mBtnUrl = findViewById(R.id.url_btn);
        mBtnUrlConn = findViewById(R.id.urlconn_btn);

    }
}
