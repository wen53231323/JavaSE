package 枚举类和注解;

public class 自定义枚举类 {
    public static void main(String[] args) {
        //自定义枚举类
        Student s1 = Student.s1;
        Student s2 = Student.s2;
        Student s3 = Student.s3;
        System.out.println(s1);// Student{id=1001, name='小明'}
        System.out.println(s2);// Student{id=1002, name='小红'}
        System.out.println(s3);// Student{id=1003, name='小刚'}
    }
}

//自定义枚举类
class Student {
    // 声明Student对象属性，private final修饰
    private final int id;
    private final String name;

    // 私有化的构造器，并给对象属性初始化
    private Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 提供当前枚举类的多个对象，public static final修饰
    public static final Student s1 = new Student(1001, "小明");
    public static final Student s2 = new Student(1002, "小明");
    public static final Student s3 = new Student(1003, "小刚");

    // 获取枚举类对象的属性
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

