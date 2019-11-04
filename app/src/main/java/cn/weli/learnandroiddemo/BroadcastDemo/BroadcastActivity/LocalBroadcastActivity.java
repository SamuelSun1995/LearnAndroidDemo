package cn.weli.learnandroiddemo.BroadcastDemo.BroadcastActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class LocalBroadcastActivity extends AppCompatActivity {

    private Button mCreate;
    private LocalBroadcastManager mLocalBroadcastManager;
    public static String action = "cn.weli.broadcast.LOCAL_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);
        mCreate = findViewById(R.id.create_local_broadcast);
        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送本地广播
                mLocalBroadcastManager = LocalBroadcastManager.getInstance(LocalBroadcastActivity.this);
                Intent intent = new Intent(action);
                Bundle bundle = new Bundle();
                bundle.putString("lbc","接收到本地广播数据");
                bundle.putChar("lb",'l');
                intent.putExtras(bundle);
                mLocalBroadcastManager.sendBroadcast(intent);
                Toast.makeText(LocalBroadcastActivity.this,"本地广播已发送",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
