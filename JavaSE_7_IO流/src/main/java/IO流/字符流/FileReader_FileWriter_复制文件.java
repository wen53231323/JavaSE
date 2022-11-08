package IO流.字符流;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_FileWriter_复制文件 {
    /**
     * 读取并写出（文本文件复制）
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，输入流和输出流fileReader、FileWriter
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     */
    @Test
    public void test() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("hello.txt");
            File file2 = new File("E:\\test.txt");

            //（2）提供具体流读写文件，输入流和输出流fileReader、FileWriter
            fileReader = new FileReader(file1);// 读取
            fileWriter = new FileWriter(file2);// 写出

            //（3）读入数据并写出数据到硬盘的文件里（复制的过程）
            char[] c = new char[5];//创建一个临时存放数据的数组
            int num;// 记录每次读入到数组的个数
            while ((num = fileReader.read(c)) != -1) {
                // 每次写入num个字符
                fileWriter.write(c, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
