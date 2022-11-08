package IO流.字符流;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;

public class FileReader读取文件 {

    /**
     * 读取文件流程：
     * （1）实例化File类的对象，指明要操作的文件
     * （2）提供具体流读取文件，FileReader
     * （3）数据的读入：创建一个临时存放数据的数组、调用流对象的读取方法，将流中的数据读入到数组中，并遍历数组
     * （4）流的关闭操作
     */
    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");

            //（2）提供具体流读取文件，FileReader
            fileReader = new FileReader(file);

            //（3）数据的读入
            // read()：返回读入的一个字符，如果达到文件末尾，返回-1
            int data = fileReader.read();//记录每次读入到数组的个数
            while (data != -1) {
                System.out.print((char) data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");

            //（2）提供具体流读取文件，FileReader
            fileReader = new FileReader(file);

            //（3）数据的读入
            int data;//记录每次读入到数组的个数
            // read()：返回读入的一个字符，如果达到文件末尾，返回-1
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取文件优化：对read()操作升级，使用read的重载方法
     */
    @Test
    public void test3() {
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //（2）提供具体流
            fileReader = new FileReader(file);
            //（3）数据的读入
            char[] c = new char[5];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = fileReader.read(c)) != -1) {
                for (int i = 0; i < num; i++) {
                    System.out.print(c[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() {
        FileReader fileReader = null;
        try {
            //（1）实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //（2）提供具体流
            fileReader = new FileReader(file);
            //（3）数据的读入
            char[] c = new char[5];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = fileReader.read(c)) != -1) {
                String str = new String(c, 0, num);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
