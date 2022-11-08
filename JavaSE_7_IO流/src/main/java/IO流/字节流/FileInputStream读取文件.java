package IO流.字节流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream读取文件 {
    /**
     * 文件读取
     * （1）实例化File类的对象，指明要操作的文件
     * （2）造字节输入流，FileInputStream
     * （3）读数据
     * （4）关闭流
     */
    @Test
    public void test() {
        FileInputStream fileInputStream = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("1.png");
            //（2）造字节流，FileInputStream
            fileInputStream = new FileInputStream(file);
            //（3）读数据
            byte[] b = new byte[3];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = fileInputStream.read(b)) != -1) {
                String str = new String(b, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）关闭流
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
