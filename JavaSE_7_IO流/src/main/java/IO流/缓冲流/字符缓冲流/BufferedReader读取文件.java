package IO流.缓冲流.字符缓冲流;

import org.junit.Test;

import java.io.*;

public class BufferedReader读取文件 {
    /**
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读文件，输入流FileReader、输入缓冲流bufferedReader
     * （3）读取数据
     * （4）流的关闭操作
     * 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
     */
    @Test
    public void readerFile() {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file = new File("hello.txt");
            //（2）提供具体流读写文件
            //造节点流
            fileReader = new FileReader(file);
            //造缓冲流
            bufferedReader = new BufferedReader(fileReader);
            //（3）读取数据
            char[] c = new char[3];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = bufferedReader.read(c)) != -1) {
                String str = new String(c, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作(关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略)
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
