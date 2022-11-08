package IO流.缓冲流.字节缓冲流;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream写出文件 {
    /**
     * 写出文件流程：
     * （1）实例化File类的对象，指明写出的文件及地址
     * （2）造字节输出流和缓冲流，FileOutputStream、BufferedOutputStream
     * （3）从内存中写出数据到硬盘的文件里
     * （4）关闭流
     */
    @Test
    public void outputFile() {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //（1）实例化File类的对象，指明写出的文件及地址
            File file = new File("E:\\test.txt");
            //（2）造流
            //造节点流
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            //造缓冲流
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //（3）从内存中写出数据到硬盘的文件里
            bufferedOutputStream.write(12345);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）关闭流
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
