package cn.weli.learnandroiddemo.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {
    //定义当前线程所处理的Socket
    Socket s = null;
    //该线程所处理的Socket所对应的输入流
    BufferedReader br =null;

    public ServerThread(Socket s){
        this.s = s;
        //初始化该Socket对应的输入流
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream() ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        String content = null;
        //采用循环不断的从Socket读取客户端发过来的数据
        while((content=readFromClient())!=null){
            //便利socketList中的每个socket
            //将读到的内容向每个Socket发送一次
            for(Socket sd : MyServer.socketList){
                OutputStream outputStream = null;
                try {
                    outputStream = sd.getOutputStream();
                    outputStream.write((content+"\n").getBytes("utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                    //删除该socket
                    MyServer.socketList.remove(sd);
                    System.out.println(MyServer.socketList);
                }

            }
        }

    }

    public String readFromClient(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            //删除该Socket
            MyServer.socketList.remove(s);
        }
        return null;
    }
}
