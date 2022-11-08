package com.wen.UDP网络编程案例;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientB {
    public static void main(String[] args) throws IOException {
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
