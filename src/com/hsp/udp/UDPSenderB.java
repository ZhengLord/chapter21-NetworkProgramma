package com.hsp.udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，准备在9998接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        //2.将需要发送的数据，封装到DatagramPacket对象
        byte[] data="hello 明天吃火锅".getBytes(StandardCharsets.UTF_8);
        //InetAddress.getByName(里面填发送端的ip)
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        socket.send(packet);
        //==================
        byte[] buf=new byte[64*1024];
         packet = new DatagramPacket(buf, buf.length);
        //调用接收方法
        //当有数据包发送到9998端口，就会接收数据否则会阻塞等待
        System.out.println("接收端A 等待接收数据");
        socket.receive(packet);
        //把packet进行拆包，取出数据
        int length=packet.getLength();//实际收到的数据字节长度
         data= packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        //关闭资源
        socket.close();
        System.out.println("B端退出");
    }
}
