package IO流.RandomAccessFile类;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class 数据的插入操作 {
    /**
     * RandomAccessFile类实现数据的插入
     */
    @Test
    public void test() {
        RandomAccessFile randomAccessFile = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            randomAccessFile = new RandomAccessFile(new File("hello.txt"), "rw");

            //（2）数据的操作
            randomAccessFile.seek(3);//将文件记录指针定位到 3 的位置
            //保存指针3后面的所有数据到stringBuffer中
            StringBuffer stringBuffer = new StringBuffer((int) (new File("hello.txt").length()));
            byte[] b = new byte[5];
            int num;
            while ((num = randomAccessFile.read(b)) != -1) {
                String str = new String(b, 0, num);
                stringBuffer.append(str);
            }
            //调回指针写入数据
            randomAccessFile.seek(3);//将文件记录指针定位到 3 的位置
            randomAccessFile.write("123".getBytes());//覆盖
            //将stringBuffer中的数据再写入到文件
            randomAccessFile.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）流的关闭操作
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
