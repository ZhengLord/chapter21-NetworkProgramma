package com.hsp.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //连接服务端
        //连接本机的9999端口，如果链接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回="+socket.getClass());
        //连接上后，生成Socket，通过socket.getOutputStream（）
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server 字符流");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束,注意要求对方使用readLine（）！！！
        bufferedWriter.flush();//如果使用字符流，需要手动刷新，否则数据不会写入数据通道

        socket.shutdownOutput();//结束标记
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭流对象和socket
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
