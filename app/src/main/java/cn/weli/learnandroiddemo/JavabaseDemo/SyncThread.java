package cn.weli.learnandroiddemo.JavabaseDemo;

import android.util.Log;

public class SyncThread {

    public static final String TAG = "SyncThread";

    private final Object lock = new Object();

    public void foo() {
        synchronized (SyncThread.class) {
            for (int i = 0; i < 5; i++) {
                Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>foo: " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }

    public void bar() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                Log.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<bar: " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }

    public void cpp() throws Exception {
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                Log.i(TAG, "===================================cpp: " + i);
                Thread.sleep(1000);
            }
        }
    }

    public void der() throws Exception {
        for (int i = 0; i < 5; i++) {
            Log.i(TAG, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!der: " + i);
            Thread.sleep(1000);
        }
    }


}
