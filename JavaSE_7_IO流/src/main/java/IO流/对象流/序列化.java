package IO流.对象流;

import IO流.Person;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class 序列化 {
    /**
     * 序列化：对象—>字节序列
     * 用ObjectOutputStream类将内存中的java对象保存到磁盘中或通过网络传输出去
     */
    @Test
    public void test() {
        ObjectOutputStream objectOutputStream = null;
        try {
            //（1）创建连接到指定文件的数据输出流对象
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("hello.txt"));
            //（2）写入对象数据
            objectOutputStream.writeObject(new String("你好java"));
            objectOutputStream.writeObject(new Person("小明", 18));
            objectOutputStream.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）关闭流
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
