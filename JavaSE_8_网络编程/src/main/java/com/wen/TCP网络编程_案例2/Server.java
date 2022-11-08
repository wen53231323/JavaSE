package com.wen.TCP网络编程_案例2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 先启动服务端，等待接收来自客户端的消息
 * 然后启动客户端，客户端发送文件给服务端
 * 服务端接收到文件，保存文件到本地
 * 注意：实际需要使用try-catch处理异常
 */

/**
 * 服务端：接收文件，保存文件到本地
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //（1）创建服务器端的ServerSocket对象，指明自己的端口号
        ServerSocket serverSocket = new ServerSocket(8899);

        //（2）调用accept()方法，表示可以接受来自客户端的Socket
        System.out.println("等待连接...");
        Socket accept = serverSocket.accept();
        System.out.println("连接成功！");

        //（3）获取输入流
        System.out.println("开始接收文件...");
        InputStream inputStream = accept.getInputStream();
        System.out.println("接收成功！");
        System.out.println("收到来自于：" + serverSocket.getInetAddress().getHostAddress() + "的数据");

        //（4）获取输出流，写数据
        System.out.println("开始写入文件...");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("test.txt"));

        //（5）读取输入流中的数据
        byte[] b = new byte[20];
        int num;
        while ((num = inputStream.read(b)) != -1) {
            fileOutputStream.write(b, 0, num);
        }
        System.out.println(inputStream.toString());
        System.out.println("写入成功！");

        //（6）资源的关闭
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
