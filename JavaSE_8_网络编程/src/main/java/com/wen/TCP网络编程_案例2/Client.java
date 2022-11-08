package com.wen.TCP网络编程_案例2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 先启动服务端，等待接收来自客户端的消息
 * 然后启动客户端，客户端发送文件给服务端
 * 服务端接收到文件，保存文件到本地
 * 注意：实际需要使用try-catch处理异常
 */
/**
 * 客户端：发送文件给服务端
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        //（1）创建Socket对象，指明服务器端的ip和端口号
        System.out.println("等待连接服务端...");
        Thread.sleep(1000);
        Socket socket = new Socket("127.0.0.1", 8899);
        System.out.println("连接服务端成功！");

        //（2）获取一个输出流，用于输出数据
        System.out.println("开始发送文件...");
        Thread.sleep(1000);
        // 获取一个输出流，用于输出数据
        OutputStream outputStream = socket.getOutputStream();

        //（3）获取输入流，读数据
        FileInputStream fileInputStream = new FileInputStream(new File("hello.txt"));

        //（4）读写过程
        byte[] b = new byte[3];
        int num;//记录每次读入到数组的个数
        while ((num = fileInputStream.read(b)) != -1) {
            outputStream.write(b, 0, num);
        }
        System.out.println("文件发送完毕！");

        //（5）资源的关闭
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }
}
