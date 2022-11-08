package com.wen.TCP网络编程_案例1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
/**
 * 先启动服务端，等待接收来自客户端的消息
 * 然后启动客户端，发送内容给服务端
 * 服务端收到消息，将内容打印到控制台上
 */

/**
 * 客户端：发送内容给服务端
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //（1）创建Socket对象，指明服务器端的ip和端口号
            System.out.println("等待连接服务端...");
            Thread.sleep(1000);
            socket = new Socket("127.0.0.1", 8899);
            System.out.println("连接服务端成功！");

            //（2）获取一个输出流，用于输出数据
            outputStream = socket.getOutputStream();

            //（3）写出数据的操作
            outputStream.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //（4）资源的关闭
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
