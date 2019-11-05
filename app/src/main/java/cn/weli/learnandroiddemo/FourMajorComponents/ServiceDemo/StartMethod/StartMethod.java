package cn.weli.learnandroiddemo.FourMajorComponents.ServiceDemo.StartMethod;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import cn.weli.learnandroiddemo.FourMajorComponents.ServiceDemo.ServiceDto;
import cn.weli.learnandroiddemo.FourMajorComponents.ServiceDemo.ServiceMainActivity;

public class StartMethod extends Service {

    public static final String TAG = "startService";
    private int mNum = ServiceDto.getStartServiceNum() + 1;
    public int onStartCommand = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate**************");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand**************:" + onStartCommand);
        onStartCommand++;
        new Thread() {
            @Override
            public void run() {
                super.run();
                Log.i(TAG, "开始打印0~100的数。");
                int i = 0;
                while (i <= 100) {
                    Log.i(TAG, "" + i);
                    i++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind**************");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy**************");
        ServiceMainActivity.startCount = 1;
    }
}
