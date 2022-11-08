package 泛型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 自定义泛型方法 {
    public static void main(String[] args) {
        test test = new test();
        Integer[] arr = new Integer[]{1,2,3};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = test.test(arr);
        System.out.println(list);//[1,2,3]
    }
}
class test{
    //泛型方法：在泛型中出现了泛型结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型所属的类是不是泛型类都没有关系
    //泛型方法可以声明为静态的，原因：泛型参数是在调用方法时确定的，并非在实例化类时确定
    public static  <E> List<E> test(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e:arr) {
            list.add(e);
        }
        return list;
    }
}
