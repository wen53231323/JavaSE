package IO流.对象流;

import IO流.Person;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class 反序列化 {
    /**
     * 反序列化：字节序列—>对象
     * 用ObjectInputStream类将磁盘文件读取(还原)为内存中的一个java对象
     */
    @Test
    public void test() {
        ObjectInputStream objectInputStream = null;
        try {
            //（1）创建连接到指定文件的数据输入流对象
            objectInputStream = new ObjectInputStream(new FileInputStream("hello.txt"));
            //（2）读取对象数据
            Object o = objectInputStream.readObject();
            String str = (String) o;
            Person person = (Person) objectInputStream.readObject();

            System.out.println(str);//你好java
            System.out.println(person);//Person{name='小明', age=18}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
