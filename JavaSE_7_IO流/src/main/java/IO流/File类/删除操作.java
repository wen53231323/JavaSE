package IO流.File类;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class 删除操作 {
    @Test
    public void test() throws IOException {
        File file = new File("test.txt");
        file.mkdir();
        boolean delete = file.delete();
        if (delete){
            System.out.println("删除成功");
        }else{
            System.out.println("没有这个文件");
        }
    }
}
