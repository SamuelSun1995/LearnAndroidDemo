package cn.weli.learnandroiddemo.Resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import cn.weli.learnandroiddemo.R;

public class UseOriActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer1;
    private MediaPlayer mMediaPlayer2;
    private Button mBtnMediaPlayer1;
    private Button mBtnMediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_ori);
        //根据声音文件的ID来创建MediaPlayer
        mMediaPlayer1 = MediaPlayer.create(this,R.raw.that_time);
        //获取该应用的AssetManager
        AssetManager am = getAssets();
        //获取指定文件对应的AssetFileDescriptor
        try {
            AssetFileDescriptor afd = am.openFd("he.mp3");
           mMediaPlayer2 = new MediaPlayer();
           //使用MediaPlayer加载指定的声音文件
            mMediaPlayer2.setDataSource(afd.getFileDescriptor());
            mMediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mBtnMediaPlayer1 = findViewById(R.id.btn_media1);
        mBtnMediaPlayer2 = findViewById(R.id.btn_media2);
        mBtnMediaPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer1.start();
            }
        });

        mBtnMediaPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer2.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mMediaPlayer1!=null){
            mMediaPlayer1.stop();
            mMediaPlayer1.release();
        }

        if(mMediaPlayer2!=null){
            mMediaPlayer2.stop();
            mMediaPlayer2.release();
        }
    }
}
