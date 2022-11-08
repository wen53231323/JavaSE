package com.wen;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress类 {
    public static void main(String[] args) throws UnknownHostException {
        // getByName(String host):在给定主机名的情况下确定主机的IP地址
        InetAddress ip1 = InetAddress.getByName("192.168.10.10");//ip
        System.out.println(ip1);// /192.168.10.10

        // 根据域名获取ip
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");//域名
        System.out.println(ip2);//www.baidu.com/182.61.200.7

        // 获取本机ip
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);//localhost/127.0.0.1

        // getLocalHost():返回本地主机
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-U6SJ0UST/169.254.19.111

        //getHostName()：获取域名
        System.out.println(localHost.getHostName());//LAPTOP-U6SJ0UST

        //getHostAddress()：获取主机地址
        System.out.println(localHost.getHostAddress());//169.254.19.111
    }
}
