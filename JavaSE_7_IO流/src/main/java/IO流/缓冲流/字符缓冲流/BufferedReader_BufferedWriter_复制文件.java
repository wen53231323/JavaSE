package IO流.缓冲流.字符缓冲流;

import org.junit.Test;

import java.io.*;

public class BufferedReader_BufferedWriter_复制文件 {
    /**
     * 指定路径下的文件复制：将代码封装，使用时只需要填入开始与结束路径
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，
     * 输入流和输出流FileReader、FileWriter
     * 输入缓冲流和输出缓冲流bufferedReader、bufferedWriter
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     * 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
     */
    @Test
    public void copyFile() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("E:\\1.png");
            File file2 = new File("E:\\1.png");
            //（2）提供具体流读写文件
            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2);

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            //（3）复制的细节：读取、写入
            char[] c = new char[3];
            int num;//记录每次读入到数组的个数
            while ((num = bufferedReader.read(c)) != -1) {
                //每次写入num个字符
                bufferedWriter.write(c, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作(关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略)
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
