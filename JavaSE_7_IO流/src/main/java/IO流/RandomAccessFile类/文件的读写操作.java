package IO流.RandomAccessFile类;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class 文件的读写操作 {
    /**
     * RandomAccessFile类实现文件的读写操作
     */
    @Test
    public void test() {
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            randomAccessFile1 = new RandomAccessFile(new File("带土.jpg"), "r");
            randomAccessFile2 = new RandomAccessFile(new File("带土111.jpg"), "rw");

            //（2）数据的读入
            int num;
            byte[] b = new byte[3];
            while ((num = randomAccessFile1.read(b)) != -1) {
                randomAccessFile2.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）流的关闭操作
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
