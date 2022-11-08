package IO流.数据流;

import org.junit.Test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {
    /**
     * 将内存中的字符串、基本数据类型的变量写出到文件中
     */
    @Test
    public void test() {
        DataOutputStream dataOutputStream = null;
        try {
            //（1）创建连接到指定文件的数据输出流对象
            dataOutputStream = new DataOutputStream(new FileOutputStream("test.txt"));
            //（2）写入数据
            dataOutputStream.writeUTF("你好!"); // 写UTF字符串
            dataOutputStream.writeBoolean(false); // 写入布尔值
            dataOutputStream.writeLong(1234567890L); // 写入长整数
            System.out.println("写文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）关闭过滤流时,会自动关闭它包装的底层节点流
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
