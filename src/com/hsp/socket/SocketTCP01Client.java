package com.hsp.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //连接服务端
        //连接本机的9999端口，如果链接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回="+socket.getClass());
        //连接上后，生成Socket，通过socket.getOutputStream（）
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes(StandardCharsets.UTF_8));
        //关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
