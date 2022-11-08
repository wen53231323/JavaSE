package IO流.字符流;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter写出文件 {
    /**
     * 写出文件流程：
     * （1）实例化File类的对象，指明写出的文件及地址
     * （2）提供具体流写出文件，FileWriter
     * （3）从内存中写出数据到硬盘的文件里
     * （4）流的关闭操作
     * 注意事项：
     * （1）File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
     * （2）File对应的硬盘中的文件如果存在，
     * 如果流使用的构造器是FileWrite(file,false)、FileWrite(file)，则会对原有文件覆盖
     * 如果流使用的构造器是FileWrite(file,true)，则不会对原有文件覆盖，而是进行追加数据
     */
    @Test
    public void test() {
        FileWriter fileWriter = null;
        try {
            //（1）实例化File类的对象，指明写出的文件及地址
            File file = new File("E:\\test.txt");
            //（2）提供具体流写出文件，FileWriter
            fileWriter = new FileWriter(file);
            //（3）从内存中写出数据到硬盘的文件里
            fileWriter.write("FileWriter流测试");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
