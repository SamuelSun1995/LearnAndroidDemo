package cn.weli.learnandroiddemo.Net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {

    public static final int POOL_NUM = 20;

    //定义保存所有Socket的ArrayList
    public static List<Socket> socketList = new ArrayList<Socket>();

    public static void main(String[] args) {

        ExecutorService mExecutorService = Executors.newFixedThreadPool(POOL_NUM);

        try {
            ServerSocket ss = new ServerSocket(30000);

            while(true){
                //此行代码会阻塞，将一直等待别人的连接
                Socket accept = ss.accept();
                //每当客户端连接后启动一个线程为该客户端服务
                mExecutorService.execute(new ServerThread(accept));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
