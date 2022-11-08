package IO流.File类;

import org.junit.Test;

import java.io.File;

public class 构造器 {
    @Test
    public void test() {
        // 相对路径
        File file1 = new File("hello.txt");
        System.out.println(file1);// hello.txt

        // 绝对路径
        File file2 = new File("E:\\test\\hello.txt");
        System.out.println(file2);// E:\test\hello.txt

        // 路径+目录
        File file3 = new File("E:\\test", "java");
        System.out.println(file3);// E:\test\java

        // File类型+文件名
        File file4 = new File(file3, "hello.txt");
        System.out.println(file4);// E:\test\java\hello.txt

        /**
         *路径中的每级目录之间需要用一个路径分隔符隔开，但路径分隔符和系统有关，
         *比如windows和DOS系统默认使用`\\`来表示、UNIX和URL使用`/`来表示，
         *为了解决Java程序跨平台运行，File类提供了一个常量，可以根据操作系统，动态的提供分隔符（盘符+路径+文件名）
         *public static final String separator;
         */
        File file5 = new File("E:" + File.separator + "test" + File.separator + "hello.txt");
        System.out.println(file5);// E:\test\hello.txt
    }
}
