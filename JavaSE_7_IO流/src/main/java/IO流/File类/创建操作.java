package IO流.File类;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class 创建操作 {
    @Test
    public void test5() throws IOException {
        File file1 = new File("test1.txt");
        // createNewFile()：创建文件。若文件存在，则不创建，返回false
        boolean exists = file1.createNewFile();
        if (exists) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }

        File file2 = new File("E:\\test1");
        // mkdir()：创建文件目录。如果此文件目录存在，就不创建了,如果此文件目录的上层目录不存在，也不创建（不能创建多级目录）
        // 如果file2不存在，就创建为目录，存在就打印失败
        boolean mkdir = file2.mkdir();
        if (mkdir) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }

        File file3 = new File("E:\\test1\\test2\\test3");
        // mkdirs()：创建文件目录。如果上层文件目录不存在，一并创建（可以创建多级目录）
        boolean mkdirs = file3.mkdirs();
        if (mkdirs) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
    }
}
