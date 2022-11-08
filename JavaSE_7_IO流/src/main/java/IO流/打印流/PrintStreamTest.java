package IO流.打印流;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    /**
     * 将控制台输出的数据改为输出为文件
     */
    @Test
    public void test() {
        PrintStream printStream = null;
        try {
            //（1）指明输出文件地址并提供流
            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\text.txt"));
            //（2）创建打印输出流,把标准输出流改成输出为文件
            // true表示设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            printStream = new PrintStream(fileOutputStream, true);
            // 如果不为空就把控制台输出的数据改为输出为文件
            if (printStream != null) {
                System.setOut(printStream);
            }
            //（3）打印输出的数据：打印ASCII字符
            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                //设置每50个数据换一行
                if (i % 50 == 0) {
                    System.out.println(); //换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}
