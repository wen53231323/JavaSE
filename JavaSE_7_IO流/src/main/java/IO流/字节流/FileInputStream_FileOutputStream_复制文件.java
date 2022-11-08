package IO流.字节流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStream_FileOutputStream_复制文件 {
    /**
     * 非文本文件复制:.mp3、mp4、.avi、.rmvb、.jpg、.doc、.ppt
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，输入流和输出流FileInputStream、FileOutputStream
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     */
    @Test
    public void test() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("1.png");
            File file2 = new File("E:\\1.png");
            //（2）提供具体流读写文件，输入流和输出流FileInputStream、FileOutputStream
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);
            //（3）读入数据并写出数据到硬盘的文件里(复制的过程)
            byte[] b = new byte[3];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = fileInputStream.read(b)) != -1) {
                //每次写入num个字符
                fileOutputStream.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
