package 数据类型转换;

// 隐式类型转换 Java 面试题，求控制台打印
// 能够输出的结果：11111、22222、44444
// 实际结果：11111
public class Test {
    public static void main(String[] args) {
        byte b = 10;
        test(b); // 11111
    }

    private static void test(byte b) {
        System.out.println("11111");
    }

    private static void test(short b) {
        System.out.println("22222");
    }

    private static void test(char b) {
        System.out.println("33333");
    }

    private static void test(int b) {
        System.out.println("44444");
    }
}
