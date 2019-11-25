package cn.weli.learnandroiddemo.Net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread implements Runnable {

    //定义向UI线程发送消息的Handler对象
    private Handler mHandler;
    //定义接收UI线程的消息的Handler对象
   public Handler mRevHandler;
    //该线程所处理的Socket输入流
    private BufferedReader br;
    private OutputStream os;

    public ClientThread(Handler handler) {
        this.mHandler = handler;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("192.168.65.1", 30000);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = socket.getOutputStream();
            //启动一个子线程来读取服务器响应的数据
            new Thread() {
                @Override
                public void run() {
                    String content;
                    //不断读取Socket输入流中的内容
                    try {
                        while (!((content = br.readLine()) != null)) {

                            //每当读到服务器的数据之后，发送消息通知
                            //程序界面显示该数据
                            Message msg = new Message();
                            msg.what = 0x12345;
                            msg.obj = content;
                            mHandler.sendMessage(msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //为当前线程初始化Looper
        Looper.prepare();
        //创建rev对象
        mRevHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                //接收UI线程中用户输入数据
                switch (msg.what){
                    case 0x345:
                        //将用户在文本框内输入的内容写入网络
                        try {
                            os.write((msg.obj.toString()+"\r\n").getBytes("utf-8"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        };
        //启动looper
        Looper.loop();


    }
}
