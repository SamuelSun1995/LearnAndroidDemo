package cn.weli.learnandroiddemo.BroadcastDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.weli.learnandroiddemo.BroadcastDemo.BroadcastActivity.LocalBroadcastActivity;
import cn.weli.learnandroiddemo.R;

public class BroadcastMainActivity extends AppCompatActivity {

    private Button mSysBtn;
    private Button mCusBtn;
    private TextView mLocalMesg;
    private int mCount = 1;
    public static final String TAG = "BroadcastMainActivity";
    //本地广播接收器
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle lb = intent.getExtras();
            if (intent.getAction().equals(LocalBroadcastActivity.action)) {
                mLocalMesg.setText("" + lb.getString("lbc"));
                Log.i(TAG, "onReceive: 接收到本地广播");
                if (lb == null) {
                    mLocalMesg.setText("未接收到数据");
                }
            }

        }
    };

    //系统广播接收器
    private BroadcastReceiver mSysBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_TIME_TICK)) {
                Toast.makeText(BroadcastMainActivity.this, "系统时间改变", Toast.LENGTH_SHORT).show();
                mLocalMesg.setText("系统时间改变次数：" + mCount);
                Log.i(TAG, "onReceive: 系统时间改变次数：" + mCount);
                mCount++;
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                Toast.makeText(BroadcastMainActivity.this, "屏幕开启", Toast.LENGTH_SHORT).show();
                mLocalMesg.setText("屏幕开启");
                Log.i(TAG, "onReceive: 屏幕开启");
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                Toast.makeText(BroadcastMainActivity.this, "屏幕关闭", Toast.LENGTH_SHORT).show();
                mLocalMesg.setText("屏幕关闭");
                Log.i(TAG, "onReceive: 屏幕关闭");
            } else if (intent.getAction().equals(LocalBroadcastActivity.action)) {
                Log.i(TAG, "系统广播接收到本地广播！！！！！！！！！！！！！！！！！！！！！！！！");  //不会接收到此广播
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_main);
        mSysBtn = findViewById(R.id.sys_broadcast);
        mCusBtn = findViewById(R.id.cus_broadcast);
        mLocalMesg = findViewById(R.id.tv_broadcast);
        //系统广播
        mSysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //自定义广播
        mCusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入新的Activity
                Intent intent = new Intent(BroadcastMainActivity.this, LocalBroadcastActivity.class);
                startActivity(intent);
            }
        });


        //注册本地广播
        IntentFilter intentFilter = new IntentFilter();
        //本地广播
        intentFilter.addAction(LocalBroadcastActivity.action);
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, intentFilter);
        //注册系统广播接收器
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mSysBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mSysBroadcastReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
    }
}
