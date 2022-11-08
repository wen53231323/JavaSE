package 异常处理.自定义异常类;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
// 使用自定义类
// 在需要抛出异常的地方使用自定义异常类
public class Test {
    public static void main(String[] args) throws MyException {
        Test test = new Test();
        System.out.println(test.test(6,2));
        //调用自定义异常类的方法
        test.throwMyException();
    }

    public int test(int i,int j) throws MyException {
        if(i<0 || j<0){
            // 使用自定义异常类抛出（throw）异常
            throw new MyException("分子或分母不能为负数");
        }
        return i/j;

    }
    // 将异常抛给方法的调用者
    public static void throwMyException() throws MyException {

        try {
            // （1）可能出现 文件找不到 异常
            FileInputStream input = new FileInputStream(new File("test.txt"));

            // （2）可能出现 空指针 异常
            String str = null;
            System.out.println(str.length());

            // （3）可能出现 数组下标越界 异常
            int[] list = new int[] { 1, 2, 3, 4, 5 };
            for (int i = 0; i <= list.length; i++) {
                System.out.println(list[i]);
            }

            // （4）可能出现 算数 异常
            int num = 1 / 0;
        }
        // （1）负责捕获“文件找不到”异常
        catch (FileNotFoundException e) {
            // 使用自定义异常类抛出（throw）异常
            throw new MyException("MyException提示的错误：文件找不到");
        }
        // （2）负责捕获“空指针”异常
        catch (NullPointerException e) {
            // 使用自定义异常类抛出（throw）异常
            throw new MyException("MyException提示的错误：空指针");
        }
        // （3）负责捕获“数组下表越界异常”
        catch (ArrayIndexOutOfBoundsException e) {
            // 使用自定义异常类抛出（throw）异常
            throw new MyException("MyException提示的错误：数组下表越界异常");
        }
        // （4）负责捕获“算数异常”
        catch (ArithmeticException e) {
            // 使用自定义异常类抛出（throw）异常
            throw new MyException("MyException提示的错误：算数异常");
        }
    }

}
