package com.hsp.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //客服端连接服务端，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        String filePath="d:\\UML.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //bytes 就是filePath对应的字节数组
        byte[] bytes =StreamUtils.streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的字节字节数组的内容，写入到数据通道
        bis.close();
        socket.shutdownOutput();//设置写入数据的结束标记

        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils的方法，直接将inputStream 读取到的内容转成字符串
        String s=StreamUtils.streamToString(inputStream);
        System.out.println(s);
        inputStream.close();
        //关闭相关的流
        bos.close();
        socket.close();

    }
}
