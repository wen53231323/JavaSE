package IO流.字节流;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream写出文件 {
    /**
     * 写出文件流程：
     * （1）实例化File类的对象，指明写出的文件及地址
     * （2）造字节输出流，FileOutputStream
     * （3）从内存中写出数据到硬盘的文件里
     * （4）关闭流
     */
    @Test
    public void test() {
        FileOutputStream fileOutputStream = null;
        try {
            //（1）实例化File类的对象，指明写出的文件及地址
            File file = new File("E:\\test.txt");
            //（2）造流
            fileOutputStream = new FileOutputStream(file);
            //（3）从内存中写出数据到硬盘的文件里
            fileOutputStream.write(12345);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）关闭流
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
