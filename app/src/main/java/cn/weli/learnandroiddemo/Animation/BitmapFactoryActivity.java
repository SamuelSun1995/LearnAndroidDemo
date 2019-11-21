package cn.weli.learnandroiddemo.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import cn.weli.learnandroiddemo.R;

public class BitmapFactoryActivity extends AppCompatActivity {

    private ImageView mImageView;
    private String[] images;
    private Button mBtnBext;

    private int currentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_factory);
        mImageView = findViewById(R.id.image_anim);

        //获取/assets/目录下的所有文件
        try {
            images= getAssets().list("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取next按钮
        mBtnBext = findViewById(R.id.btn_anim_next);
        mBtnBext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果发生数组越界
                if(currentImage>=images.length){
                    currentImage = 0;
                }
                //找到下一个图片
                while(!images[currentImage].endsWith(".png")&&!images[currentImage].endsWith(".jpg")&&!images[currentImage].endsWith(".gif")){
                    currentImage++;
                    //如果已经发生数组越界
                    if(currentImage>=images.length){currentImage=0;}}
                    InputStream assetFile = null;
                    //打开指定资源对应的输入流
                    try {
                        assetFile =getAssets().open(images[currentImage++]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) mImageView.getDrawable();
                    //如果图片还未回收，先强制回收图片
                    if(bitmapDrawable!=null&&!bitmapDrawable.getBitmap().isRecycled()){
                        bitmapDrawable.getBitmap().recycle();
                    }
                    //改变imageView显示的图片
                    mImageView.setImageBitmap(BitmapFactory.decodeStream(assetFile));

            }
        });
    }
}
