package 对象;

import org.junit.Test;

public class 创建对象 {

    /**
     * 方式一：使用 new 关键字创建对象
     */
    @Test
    public void test1() {
        // 使用 new 关键字创建对象
        Student stu = new Student();
        // 打印对象地址
        System.out.println(stu);
    }

    /**
     * 方式二：调用 java.lang.Class 的 newInstance() 方法创建对象
     */
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 调用 java.lang.Class 类中的 forName() 方法指定实例化的类的全称
        java.lang.Class cls = java.lang.Class.forName("com.wen.Student");
        // 调用 java.lang.Class 类对象的 newInstance() 方法创建对象
        Student student = (Student) cls.newInstance();
        // 打印对象地址
        System.out.println(student);
    }

    /**
     * 方式三：调用对象的 clone() 方法创建并返回一个对象的拷贝，
     * 要实例化的类必须继承 java.lang.Cloneable 接口并重写clone()
     */
    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Student stuA = new Student();
        System.out.println(stuA);
        // 调用对象的 clone() 方法创建对象
        // clone() 方法：创建与该对象的类相同的新对象；
        try {
            //注意：因为有异常抛出，所以要捕获异常
            Student stuB = stuA.clone();
            System.out.println(stuB);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
