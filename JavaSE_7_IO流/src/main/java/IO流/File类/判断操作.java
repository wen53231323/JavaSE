package IO流.File类;

import org.junit.Test;

import java.io.File;

public class 判断操作 {
    @Test
    public void test() {
        File file = new File("hello.txt");
        // isDirectory()：判断是否是文件目录
        System.out.println(file.isDirectory());//false
        // isFile()：判断是否是文件
        System.out.println(file.isFile());//true
        // exists()：判断是否存在
        System.out.println(file.exists());//true
        // canRead()：判断是否可读
        System.out.println(file.canRead());//true
        // canWrite()：判断是否可写
        System.out.println(file.canWrite());//true
        // isHidden()：判断是否隐藏
        System.out.println(file.isHidden());//false
    }
}
