package com.hsp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
//一个数据包最大64K
        byte[] buf=new byte[64*1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //调用接收方法
        //当有数据包发送到9999端口，就会接收数据否则会阻塞等待
        System.out.println("接收端A 等待接收数据");
        socket.receive(packet);
        //把packet进行拆包，取出数据
        int length=packet.getLength();//实际收到的数据字节长度
        byte[] data= packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        //=================================
        data="好的，明天见".getBytes(StandardCharsets.UTF_8);
        //InetAddress.getByName(里面填发送端的ip)
        packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9998);
        socket.send(packet);
        //关闭资源
        socket.close();
        System.out.println("A端退出");
    }
}
