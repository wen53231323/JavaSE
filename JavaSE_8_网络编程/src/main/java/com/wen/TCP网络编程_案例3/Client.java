package com.wen.TCP网络编程_案例3;

import java.io.*;
import java.net.Socket;
/**
 * 先启动服务端，等待接收来自客户端的消息
 * 然后启动客户端，客户端发送文件给服务端
 * 服务端接收到文件，保存文件到本地
 * 保存文件成功后，返回提示信息给客户端，并关闭相应的连接。
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
        OutputStream outputStream = socket.getOutputStream();

        //（3）获取输入流，读数据
        FileInputStream fileInputStream = new FileInputStream(new File("hello.txt"));

        //（4）读写过程
        byte[] b = new byte[3];
        int num;//记录每次读入到数组的个数
        while ((num = fileInputStream.read(b)) != -1) {
            outputStream.write(b, 0, num);
        }
        // 关闭数据的输出(如果不关闭，服务端不知道什么时候传完，导致程序阻塞)
        socket.shutdownOutput();
        System.out.println("文件发送完毕！");

        //（5）接收来自服务器端的数据，并显示到控制台
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[3];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        System.out.println(byteArrayOutputStream.toString());

        //（6）资源的关闭
        byteArrayOutputStream.close();
        inputStream.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }
}
