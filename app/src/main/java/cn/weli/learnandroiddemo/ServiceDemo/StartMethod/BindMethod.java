package cn.weli.learnandroiddemo.ServiceDemo.StartMethod;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindMethod extends Service {

    public static final String TAG = "bindMethod";
    public int onStartCommand = 1;
    public String data;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate**************");
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                while (true) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    Log.i(TAG, "run: " + data);
//                }
//            }
//        }.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand**************:" + onStartCommand);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind**************");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind**************:"+data);
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class MyBinder extends Binder {
        //让Activity可以调用
        public void sendData(String data) {
            BindMethod.this.data = data;
        }
    }
}
