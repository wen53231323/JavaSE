package IO流.转换流;

import org.junit.Test;

import java.io.*;
import java.io.OutputStreamWriter;

public class 文件编解码 {
    /**
     * 将已有的utf-8格式的文件装换为gbk格式
     * 解码：字节、字节数组 —> 字符串、字符数组
     * 编码：字符串、字符数组 —> 字节、字节数组
     */
    @Test
    public void test() throws IOException {
        InputStreamReader inputStreamReader = null;
        java.io.OutputStreamWriter outputStreamWriter = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File("hello.txt");
            File file2 = new File("test.txt");

            //（2）提供具体流读写字节文件，输入流和输出流FileInputStream、FileOutputStream
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");

            //（3）读入数据并写出数据到硬盘的文件里(复制的过程)
            char[] c = new char[5];
            int num;//记录每次读入到数组的个数
            while ((num = inputStreamReader.read(c)) != -1) {
                //每次写入num个字符
                outputStreamWriter.write(c, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        }
    }
}
