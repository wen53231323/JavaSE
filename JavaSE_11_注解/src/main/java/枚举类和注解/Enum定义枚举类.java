package 枚举类和注解;

public class Enum定义枚举类 {
    public static void main(String[] args) {
        EnumTest e1 = EnumTest.e1;
        EnumTest e2 = EnumTest.e2;
        EnumTest e3 = EnumTest.e3;
        System.out.println(e1);// EnumTest{id=1001, name='小明'}
        System.out.println(e2);// EnumTest{id=1002, name='小红'}
        System.out.println(e3);// EnumTest{id=1003, name='小刚'}

        // values()方法：返回枚举类型的对象数组
        EnumTest[] values = EnumTest.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        // valueOf(String str)：返回指定枚举类对象,如果没有这个枚举类对象，则抛异常：IllegalArgumentException。
        EnumTest e = EnumTest.valueOf("e1");
        System.out.println(e);

        // ordinal()：获取枚举成员的索引位置
        int ordinal = EnumTest.e1.ordinal();
        System.out.println(ordinal);
    }
}

//使用enum关键字定义枚举类
enum EnumTest {
    // 提供当前枚举类的多个对象，多个对象之间用","隔开，用";"结束
    e1(1001, "小明"),
    e2(1002, "小红"),
    e3(1003, "小刚");
    // 声明对象的属性，private final修饰
    private final int id;
    private final String name;

    // 私有化的构造器，并给对象属性初始化
    EnumTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 获取枚举类对象的属性
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EnumTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
