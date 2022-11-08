package 集合.Collection单列集合接口.Collection接口方法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class 查询操作 {
    @Test
    public void test() {
        Collection arrayList = new ArrayList();
        arrayList.add("AA");
        Collection newArrayList = new ArrayList();
        newArrayList.add("AA");

        // size()：获取添加的元素个数
        System.out.println(arrayList.size());// 1

        // isEmpty()：判断集合是否为空
        System.out.println(arrayList.isEmpty());// false

        // contains(Object o)：是否包含元素，如果此集合包含指定的元素，则返回true
        System.out.println(arrayList.contains("AA"));// true

        // containsAll(Collection<?>)：如果此集合包含指定集合中的所有元素，则返回true。
        System.out.println(arrayList.containsAll(newArrayList));// true

        // equals(Object obj)：判断集合元素是否相等
        System.out.println(arrayList.equals(newArrayList));// true

        // hashCode()：返回当前对象的哈希值
        System.out.println(arrayList.hashCode());// 2111
    }
}
