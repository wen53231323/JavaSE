package 对象;

public class Student implements Cloneable {
    // 因为实现了Cloneable接口，所以需要重写clone()方法
    protected Student clone() throws CloneNotSupportedException {
        Student stu = (Student) super.clone();
        return stu;
    }
}
