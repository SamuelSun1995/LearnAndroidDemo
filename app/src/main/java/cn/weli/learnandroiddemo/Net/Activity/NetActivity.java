package cn.weli.learnandroiddemo.Net.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.weli.learnandroiddemo.Net.Client;
import cn.weli.learnandroiddemo.Net.ClientThread;
import cn.weli.learnandroiddemo.Net.ServerSocketDemo;
import cn.weli.learnandroiddemo.R;

public class NetActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnServer;
    private Button mBtnClient;
    private TextView mTvShow;
    private EditText mEdClient;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(10);
    private ClientThread mClientThread;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x123:
                    mTvShow.setText("接受到服务器的数据：" + msg.getData().getString("line"));
                    break;
                case 0x12345:
                    mTvShow.append("\n" + msg.obj.toString());
                    break;
                case 0x345:
                    mEdClient.setText("");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        initView();
        setListener();
    }

    private void setListener() {
        mBtnServer.setOnClickListener(this);
        mBtnClient.setOnClickListener(this);
    }

    private void initView() {

        mBtnServer = findViewById(R.id.btn_client1);
        mBtnClient = findViewById(R.id.btn_client2);
        mTvShow = findViewById(R.id.tv_show_net);
        mEdClient = findViewById(R.id.ed_client);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_client1:
                //建立服务端
//                new ServerSocketDemo()
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        conn();
                    }
                }.start();
                break;
            case R.id.btn_client2:
                conn2();
                break;
        }
    }


    private void conn() {   //创建连接到192.168.1.88、3000端口的socket
        try {
            Socket socket = new Socket("192.168.65.182", 30000);
            //将socket对应的输入流包装成BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //进行普通IO操作
            String line = reader.readLine();

            Bundle bundle = new Bundle();
            bundle.putString("line", line);
            Message msg = new Message();
            msg.setData(bundle);
            msg.what = 0x123;
            mHandler.sendMessage(msg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void conn2() {
        mClientThread = new ClientThread(mHandler);
        //客户端启动ClientThread线程创建网络，读取来自服务器的数据
        mExecutorService.execute(mClientThread);
        Message msg = new Message();
        msg.what = 0x345;
        msg.obj = mEdClient.getText().toString().trim();
        if(msg!=null) {
           mClientThread.mRevHandler.sendMessage(msg);
        }
        mHandler.sendEmptyMessage(0x345);

    }
}
