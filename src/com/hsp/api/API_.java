package com.hsp.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-MODNJ8VR/10.159.14.253
        //根据指定主机名 获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("LAPTOP-MODNJ8VR");
        System.out.println(host1);
        //根据域名返回 InetAddress对象，如百度
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);
        //通过 InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println(hostAddress);
        //通过InetAddress 对象，获取对应的主机名或者域名
        String hostName = host2.getHostName();
        System.out.println(hostName);

    }
}
