package IO流.缓冲流.字符缓冲流;

import org.junit.Test;

import java.io.*;

public class BufferedWriter写出文件 {
    @Test
    public void writerFile() {
        BufferedWriter bufferedWriter = null;
        try {
            //（1）实例化File类的对象，指明写出的文件及地址
            File file = new File("E:\\test.txt");
            //（2）提供具体流写出文件，FileWriter
            // 造节点流
            FileWriter fileWriter = new FileWriter(file);
            // 造缓冲流
            bufferedWriter = new BufferedWriter(fileWriter);
            //（3）从内存中写出数据到硬盘的文件里
            bufferedWriter.write("hello");
            bufferedWriter.newLine();//插入一个和系统相关的换行符
            bufferedWriter.write("hello");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\note.txt";
        //（1）创建BufferedWriter,在节点流上多一个 true 表示追加写入内容，不加就是覆盖
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        //（2）写入内容与换行
        bufferedWriter.write("hello");
        bufferedWriter.newLine();//插入一个和系统相关的换行符
        bufferedWriter.write("hello");

        //（3）关闭外层流即可，传入的 new FileWriter(filePath)会在底层自动关闭
        bufferedWriter.close();
    }
}
