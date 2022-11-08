package com.wen.URL编程;

import org.junit.Test;

import java.io.*;
import java.net.*;

public class URL编程 {
    @Test
    public void test1() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        //public String getProtocol( ) 获取该URL的协议名
        System.out.println("getProtocol() :" + url.getProtocol());//https
        //public String getHost( ) 获取该URL的主机名
        System.out.println("getHost() :" + url.getHost());//www.baidu.com
        //public String getPort( ) 获取该URL的端口号
        System.out.println("getPort() :" + url.getPort());//-1
        //public String getPath( ) 获取该URL的文件路径
        System.out.println("getPath() :" + url.getPath());//  /
        //public String getFile( ) 获取该URL的文件名
        System.out.println("getFile() :" + url.getFile());//  /
        //public String getQuery( ) 获取该URL的查询名
        System.out.println("getQuery() :" + url.getQuery());//null
    }

    @Test
    public void test2() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        // openConnection()：打开与URL的连接，允许客户端与资源通信
        URLConnection urlConnection = url.openConnection();
        // 获取连接
        urlConnection.connect();
        // 获得输入流
        InputStream inputStream = urlConnection.getInputStream();
        // 将流中数据保存本地
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\test.html"));
        byte[] b = new byte[3];
        int num;
        while ((num = inputStream.read(b)) != -1) {
            fileOutputStream.write(b, 0, num);
        }
        System.out.println("下载完成");
        // 关闭资源
        fileOutputStream.close();
        inputStream.close();
    }



}
