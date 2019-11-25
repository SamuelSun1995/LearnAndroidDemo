package cn.weli.learnandroiddemo.Net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) {
        establishConnect();
    }

    public static void establishConnect() {

        //创建一个socket，用于监听客户端socket的连接请求
        try {
            ServerSocket ss = new ServerSocket(30000);

            //采用循环不断接受来自客户端的请求
            while (true) {
                //每当接受到客户端Socket请求，服务端也对应长生一个Socket
                Socket accept = ss.accept();
                OutputStream outputStream = accept.getOutputStream();
            outputStream.write("您好！你收到服务器的新年祝福!szx++++++asdajkdjaksdjasldjaskdjalksdjalskdjlaskdjlasjlkaskjdlkasdkmlass\n".getBytes("utf-8"));
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
