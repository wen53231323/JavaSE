package IO流.转换流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    /**
     * 解码：字节、字节数组 —> 字符串、字符数组
     */
    @Test
    public void test() {
        InputStreamReader inputStreamReader = null;
        try {
            //（1）指明文件并提供流
            // 节点流
            FileInputStream fileInputStream = new FileInputStream(new File("test.txt"));
            // 转换流，第二个参数默认为当前使用的编码
            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            //（2）数据的读入
            char[] c = new char[3];
            int num;
            while ((num = inputStreamReader.read(c)) != -1) {
                String str = new String(c, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（3）流的关闭操作
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
