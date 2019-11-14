package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class NotiActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);
        //1. 获取系统的mNotificationManager服务
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //设置通知Channel的名字
        String name = "测试Channel";
        //2. 创建通知
        NotificationChannel channel;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);
        } else {
            Toast.makeText(this, "版本不对！", Toast.LENGTH_SHORT).show();
            return;
        }
        //设置通知channel的描述信息
        channel.setDescription("测试Channel的描述信息！");
        //设置通知出现时的闪光灯
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        //设置通知时出现振动
        channel.enableVibration(true);
        channel.setVibrationPattern(new long[]{0, 50, 100, 150});
//        channel.setSound(Uri.parse());
        //最后在NotificationManager上创建通知
        mNotificationManager.createNotificationChannel(channel);
    }
}
