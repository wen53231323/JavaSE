package IO流.缓冲流.字节缓冲流;

import org.junit.Test;

import java.io.*;

public class BufferedInputStream写入文件 {
    @Test
    public void inputFile() {
        BufferedInputStream bufferedInputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("1.png");

            //（2）提供具体流读写文件
            //造节点流
            FileInputStream fileInputStream = new FileInputStream(file1);
            //造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            //（3）复制的细节：读取、写入
            byte[] b = new byte[3];
            int num;//记录每次读入到数组的个数
            while ((num = bufferedInputStream.read(b)) != -1) {
                String str = new String(b, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            // 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
