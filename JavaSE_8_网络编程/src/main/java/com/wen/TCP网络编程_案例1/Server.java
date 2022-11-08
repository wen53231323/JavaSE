package com.wen.TCP网络编程_案例1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 先启动服务端，等待接收来自客户端的消息
 * 然后启动客户端，发送内容给服务端
 * 服务端收到消息，将内容打印到控制台上
 */

/**
 * 服务端：将内容打印到控制台上
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //（1）创建服务器端的ServerSocket对象，指明自己的端口号
            serverSocket = new ServerSocket(8899);

            //（2）调用accept()方法，表示可以接受来自客户端的Socket
            System.out.println("等待连接...");
            accept = serverSocket.accept();
            System.out.println("连接成功！");

            //（3）获取输入流
            inputStream = accept.getInputStream();

            //（4）读取输入流中的数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] b = new byte[20];
            int num;
            while ((num = inputStream.read(b)) != -1) {
                byteArrayOutputStream.write(b, 0, num);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到来自于：" + serverSocket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（5）资源的关闭
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
