package 数据类型转换;

import org.junit.Test;

public class Demo {
    @Test
    public void test1() {
        byte A = 2;
        int B = 129;
        // byte C = A + B; // 编译不通过
        int C = A + B;
        System.out.println(C); // 131
    }

    @Test
    public void test2() {
        int x = (int) 12.34 + (int) 56.7;  // 丢失精度
        double y = (double) 10 + (double) 10;  // 提高精度
        System.out.println("x=" + x); // x=68
        System.out.println("y=" + y); // y=20.0
    }


}
