package cn.weli.learnandroiddemo.FourMajorComponents.ServiceDemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.weli.learnandroiddemo.R;
import cn.weli.learnandroiddemo.FourMajorComponents.ServiceDemo.StartMethod.BindMethod;
import cn.weli.learnandroiddemo.FourMajorComponents.ServiceDemo.StartMethod.StartMethod;

public class ServiceMainActivity extends AppCompatActivity {

    private Button mStartService;
    private Button mBindService;
    private Button mStopService;
    private Button mUnBindService;

    public static int startCount = 1;
    public static int bindCount = 1;

    public BindMethod.MyBinder myBinder;
    private MyServiceConnection myConn;
    private BindMethod bindMethod;
    public static final String TAG = "ServiceMainActivity";

//    private ServiceConnection conn = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        mStartService = findViewById(R.id.start_service);
        mBindService = findViewById(R.id.bindService);
        mStopService = findViewById(R.id.stop_service);
        mUnBindService = findViewById(R.id.unbindService);
        //出初始化mybinder
        myBinder = new BindMethod().new MyBinder();
        bindMethod = new BindMethod();
        //startActivity()方式启动
        mStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceMainActivity.this, StartMethod.class);
                startService(intent);
                Toast.makeText(ServiceMainActivity.this, "启动第" + startCount + "Service", Toast.LENGTH_SHORT).show();
                startCount++;
            }
        });

        //stopService()
        mStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceMainActivity.this, StartMethod.class);
                stopService(intent);
            }
        });

        //bindService()方法启动
        mBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启服务
                Intent intent = new Intent(ServiceMainActivity.this, BindMethod.class);
                //连接服务
                myConn = new MyServiceConnection();
                //绑定服务
                bindService(intent, myConn, BIND_AUTO_CREATE);
                Log.i(TAG, "" + bindMethod.data);
                Toast.makeText(ServiceMainActivity.this, "绑定第" + bindCount + "Service", Toast.LENGTH_SHORT).show();
                bindCount++;
            }
        });

        //unbindService
        mUnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.sendData("Activity->Service");
                if (myConn != null) {
                    unbindService(myConn);
                    Toast.makeText(ServiceMainActivity.this, "解绑service！", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ServiceMainActivity.this, "未有service绑定！", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public class MyServiceConnection implements ServiceConnection {

        //当服务连接成功
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //IBinder是传递过来的，这边我们进行获取
            myBinder = (BindMethod.MyBinder) service;
        }

        //失去连接
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
