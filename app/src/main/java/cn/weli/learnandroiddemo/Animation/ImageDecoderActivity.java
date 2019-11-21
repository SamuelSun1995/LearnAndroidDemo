package cn.weli.learnandroiddemo.Animation;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import cn.weli.learnandroiddemo.R;

public class ImageDecoderActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTv;
    private Drawable drawable;

    private Handler mHandler = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.P)
        @Override
        public void handleMessage(@NonNull Message msg) {

            switch (msg.what) {
                case 0x123:
                    mTv.setText("图片原始宽度：" + msg.getData().getInt("width") + "\n" + "图片原始高度：" + msg.getData().getInt("height"));
                    mImageView.setImageDrawable(drawable);
                    //如果drawable是AnimatedImagedImageDrawable的实例，则执行动画
                    if(drawable instanceof AnimatedImageDrawable){
                        ((AnimatedImageDrawable) drawable).start();
                    }
                    break;
            }

        }
    };

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_decoder);
        mTv = findViewById(R.id.tv_imagedecoder);
        mImageView = findViewById(R.id.image_decoder);

        //1、创建ImageDecoder.Source对象
        ImageDecoder.Source source = ImageDecoder.createSource(getResources(), R.drawable.pika);
        //2、执行decodeDrawable()方法获取Drawable对象
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    drawable = ImageDecoder.decodeDrawable(source, (decoder, info, s) -> {
                        //通过info参数获取被解码的图片信息
                        int width = info.getSize().getWidth();
                        int height = info.getSize().getHeight();
                        Bundle bundle = new Bundle();
                        bundle.putInt("width", width);
                        bundle.putInt("height", height);
                        Message msg = new Message();
                        msg.what = 0x123;
                        //设置图片解码之后的缩放大小
                        decoder.setTargetSize(600, 500);
                        mHandler.sendMessage(msg);
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
