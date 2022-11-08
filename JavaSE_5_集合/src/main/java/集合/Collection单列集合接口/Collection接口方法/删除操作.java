package 集合.Collection单列集合接口.Collection接口方法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class 删除操作 {
    @Test
    public void test1() {
        // add(Object obj)：添加单个数据，结果返回布尔值
        Collection arrayList = new ArrayList();
        arrayList.add("AA");
        arrayList.add(123);
        System.out.println(arrayList);// [AA, 123]

        // remove()：删除单个数据，结果返回布尔值
        arrayList.remove(123);// 删除123
        System.out.println(arrayList);// [AA]

        // removeIF(Predicate<? super E>)：条件删除，参数是过滤器，判断元素是否要删除
        arrayList.removeIf(test -> test.equals("AA"));// 删除AA
        System.out.println(arrayList);// []

        // clear()：清空集合
        arrayList.clear();// []
    }

    @Test
    public void test2() {
        Collection arrayList1 = new ArrayList();
        arrayList1.add("AA");
        arrayList1.add(123);
        Collection arrayList2 = new ArrayList();
        arrayList2.add("BB");
        arrayList2.add(123);
        // removeAll(Collection coll)：取差集，从当前集合中移除另一集合中相同的元素
        arrayList1.removeAll(arrayList2);
        System.out.println(arrayList1);// [AA]
    }

    @Test
    public void test3() {
        Collection arrayList1 = new ArrayList();
        arrayList1.add("AA");
        arrayList1.add(123);
        Collection arrayList2 = new ArrayList();
        arrayList2.add("BB");
        arrayList2.add(123);
        // retainAll(Collection c)：取交集，获取当前集合和另一集合的交集，并返回给当前集合
        arrayList1.retainAll(arrayList2);
        System.out.println(arrayList1);// [123]
    }
}
