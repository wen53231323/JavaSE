package IO流.File类;

import org.junit.Test;

import java.io.File;

public class 重命名操作 {
    @Test
    public void test(){
        // public boolean renameTo(File dest)：把文件重命名为指定的文件路径
        File file1 = new File("E:\\test\\hello.txt");
        File file2 = new File("hello.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }
}
