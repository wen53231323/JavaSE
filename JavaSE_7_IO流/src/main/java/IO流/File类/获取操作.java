package IO流.File类;

import org.junit.Test;

import java.io.File;
import java.util.Date;

public class 获取操作 {
    @Test
    public void test() {
        File file1 = new File("hello.txt");
        // getAbsolutePath()：获取绝对路径
        System.out.println(file1.getAbsolutePath());// D:\Java\IDEA-2018.2.7\Java\JavaSE\JavaSE_7_IO流\hello.txt
        // getPath()：获取路径
        System.out.println(file1.getPath());// hello.txt
        // getName()：获取名称
        System.out.println(file1.getName());// hello.txt
        // getParent()：获取上层文件目录路径，若无则返回null
        System.out.println(file1.getParent());// null
        // length()：获取文件长度（字节数）,不能获取目录的长度。
        System.out.println(file1.length());//5
        // lastModified()：获取最后一次的修改时间，毫秒值
        System.out.println(file1.lastModified());//1667315658044
        System.out.println(new Date(file1.lastModified()));//Tue Nov 01 23:14:18 CST 2022

        File file2 = new File("E:\\java");
        // list()：获取指定目录下的所有文件或者文件目录的名称数组
        String[] list = file2.list();
        // 遍历
        for (String f : list) {
            System.out.println(f);
        }
        // listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
        File[] files = file2.listFiles();
        // 遍历
        for (File f : files) {
            System.out.println(f);
        }
    }
}
