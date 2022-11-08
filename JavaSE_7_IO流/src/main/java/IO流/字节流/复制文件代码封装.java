package IO流.字节流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class 复制文件代码封装 {

    public static void main(String[] args) {
        // 获取开始的时间
        long startTime = System.currentTimeMillis();

        // 调用封装的复制文件逻辑实现复制
        String startPath = "E:\\1.png";
        String endPath = "E:\\1.png";
        copyFile(startPath, endPath);

        // 获取结束的时间
        long endTime = System.currentTimeMillis();

        System.out.println("复制花费的时间为：" + (endTime - startTime));//54
    }

    /**
     * 指定路径下的文件复制：将代码封装，使用时只需要填入开始与结束路径
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，输入流和输出流FileInputStream、FileOutputStream
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     *
     * @param startPath 开始路径
     * @param endPath   结束路径
     */
    public static void copyFile(String startPath, String endPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File(startPath);
            File file2 = new File(endPath);
            //（2）提供具体流读写文件，输入流和输出流FileInputStream、FileOutputStream
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);
            //（3）读入数据并写出数据到硬盘的文件里（复制的过程）
            byte[] b = new byte[3];
            int num;//记录每次读入到数组的个数
            while ((num = fileInputStream.read(b)) != -1) {
                //每次写入num个字符
                fileOutputStream.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
