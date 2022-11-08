package 泛型;

/**
 * 类中指定的泛型<T>可以随便写为任意标识，常见的有T、E等形式的参数。
 * 表示泛型泛型在定义的时候不具体，使用的时候确定泛型的具体数据类型，即在创建对象的时候确定泛型。
 */
public class Demo<T> {
    // 成员变量id的类型为T,T的类型由外部指定
    private T id;

    // 泛型构造方法形参id的类型也为T，T的类型由外部指定
    public Demo(T id) {
        this.id = id;
    }

    // 泛型方法getT的返回值类型为T，T的类型由外部指定
    public void setId(T id) {
        this.id = id;
    }


    /**
     * @param t   传入泛型的参数
     * @param <T> 泛型的类型
     * @return T 返回值为T类型
     * 说明：
     * （1）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * （2）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * （3）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E等形式的参数常用于表示泛型。
     */
    public <T> T testMethod(T t) {
        System.out.println(t.getClass());
        System.out.println(t);
        return t;
    }
}

/**
 * 定义一个泛型接口
 */
interface testInteface<T> {
    public abstract void add(T t);
}


