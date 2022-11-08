package IO流.数据流;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest {
    /**
     * 将文件中的字符串、基本数据类型的变量读取到内存中(保存在变量中)
     */
    @Test
    public void test() {
        DataInputStream dataInputStream = null;
        try {
            //（1）创建连接到指定文件的数据输入流对象
            dataInputStream = new DataInputStream(new FileInputStream("E:\\test.txt"));
            //（2）读取数据
            String info = dataInputStream.readUTF();
            boolean flag = dataInputStream.readBoolean();
            long time = dataInputStream.readLong();
            System.out.println(info);
            System.out.println(flag);
            System.out.println(time);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）关闭过滤流时,会自动关闭它包装的底层节点流
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
