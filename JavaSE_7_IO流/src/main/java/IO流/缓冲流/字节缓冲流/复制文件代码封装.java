package IO流.缓冲流.字节缓冲流;

import java.io.*;

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

        System.out.println("复制花费的时间为：" + (endTime - startTime));//1
    }

    /**
     * 指定路径下的文件复制：将代码封装，使用时只需要填入开始与结束路径
     * （1）实例化File类的对象，指明读入和写出的文件及地址
     * （2）提供具体流读写文件，
     * 输入流和输出流FileInputStream、FileOutputStream
     * 输入缓冲流和输出缓冲流bufferedInputStream、bufferedOutputStream
     * （3）读入数据并写出数据到硬盘的文件里（复制的过程）
     * （4）流的关闭操作
     * 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
     *
     * @param startPath 开始路径
     * @param endPath   结束路径
     */
    //指定路径下的文件复制
    //将代码封装，使用时只需要填入开始与结束路径
    public static void copyFile(String startPath, String endPath) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //（1）实例化File类的对象，指明读入和写出的文件及地址
            File file1 = new File(startPath);
            File file2 = new File(endPath);

            //（2）提供具体流读写文件
            //造节点流
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            //造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //（3）复制的细节：读取、写入
            byte[] b = new byte[3];//创建一个临时存放数据的数组
            int num;//记录每次读入到数组的个数
            while ((num = bufferedInputStream.read(b)) != -1) {
                //每次写入num个字符
                bufferedOutputStream.write(b, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //（4）流的关闭操作
            // 先关闭外侧的流，再关闭内层的流，因为关闭外层流的同时，内层流也会自动的进行关闭，所以内层流的关闭可以省略
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
