package com.hsp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //在本机 的9999端口监听，等待连接
        //要求在本机没有其它服务在监听9999
        ServerSocket serverSocket = new ServerSocket(9999);
        //当没有客户端连接9999端口时，程序会阻塞，等待连接
        //如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket="+socket.getClass());
        InputStream inputStream = socket.getInputStream();
        byte[] buf=new byte[1024];
        int readLen=0;
        while ((readLen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readLen));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
