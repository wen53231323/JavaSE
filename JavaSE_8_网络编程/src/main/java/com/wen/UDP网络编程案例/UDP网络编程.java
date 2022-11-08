package com.wen.UDP网络编程案例;


import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP网络编程 {
    /**
     * 发送端
     */
    @Test
    public void sender() throws IOException {
        // （1）创建数据报套接字并将其绑定到本地主机上的指定端口8000
        DatagramSocket socket = new DatagramSocket(8000);
        while (true) {
            // （2）发送信息到客户端B
            System.out.println("请输入");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            System.out.println("开始发送数据：" + msg);
            byte[] buf = msg.getBytes();
            InetAddress toIp = InetAddress.getLocalHost();
            // 封装数据为DatagramPacket数据报包，用来实现无连接包投递服务（长度为length、偏移量为offset、本地主机地址、指定端口号）
            DatagramPacket packet = new DatagramPacket(buf, buf.length, toIp, 9000);
            // 用数据报包的套接字，通过8000发送数据报
            socket.send(packet);

            // （3）接收客户端B的信息
            byte[] response = new byte[1024];
            DatagramPacket resPacket = new DatagramPacket(response, response.length);
            // 信息接收
            socket.receive(resPacket);
            String recMsg = new String(response, 0, resPacket.getLength());
            System.out.println("clientB说:" + recMsg);
            // ds.close();
        }
    }

    /**
     * 接收端
     */
    @Test
    public void test2() throws IOException {
        // （1）创建一个datagram socket 用于结束
        DatagramSocket socket = new DatagramSocket(9000);
        while (true) {
            // （2）接收客户端A的信息
            byte[] recbuf = new byte[1024];
            DatagramPacket resPacket = new DatagramPacket(recbuf, recbuf.length);
            socket.receive(resPacket);
            String recMsg = new String(recbuf, 0, resPacket.getLength());
            System.out.println("clientA说" + recMsg);

            // （3）发送信息到客户端A
            System.out.println("请输入");
            Scanner sc = new Scanner(System.in);
            String msg = sc.next();
            System.out.println("开始发送数据：" + msg);
            InetAddress toIp = InetAddress.getLocalHost();// 返回本地主机地址
            byte[] buf = msg.getBytes();
            // 封装数据为DatagramPacket数据报包，用来实现无连接包投递服务（长度为length、偏移量为offset、本地主机地址、指定端口号）
            DatagramPacket dp = new DatagramPacket(buf, buf.length, toIp, 8000);
            // 发送数据报
            socket.send(dp);
            // ds.close();
        }
    }
}
