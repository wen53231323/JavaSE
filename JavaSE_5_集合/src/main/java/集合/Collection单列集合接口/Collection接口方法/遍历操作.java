package 集合.Collection单列集合接口.Collection接口方法;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class 遍历操作 {

    Collection<String> asList = Arrays.asList("AA", "BB", "CC");
    // iterator()：返回Iterator接口的示例，用于遍历集合元素
    Iterator iterator = asList.iterator();

    @Test
    public void test1() {
        List<String> asList = Arrays.asList("AA", "BB", "CC");
        // 方式一：使用next()使指针下移，将下移以后集合位置上的元素返回
        System.out.println(iterator.next());// AA
        System.out.println(iterator.next());// BB
        System.out.println(iterator.next());// BB
    }

    @Test
    public void test2() {
        // 方式二：使用for循环+next()
        for (int i = 0; i < asList.size(); i++) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        // 方式三：使用hasNext()判断是否还有下一个元素，然后使用next()指针下移，将下移以后集合位置上的元素返回
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4() {
        // 使用增强for循环foreach，内部仍然调用了迭代器
        // 语法：for(集合元素的类型 局部变量:集合对象){}
        for (Object obj : asList) {
            System.out.println(obj);
        }
    }
}
