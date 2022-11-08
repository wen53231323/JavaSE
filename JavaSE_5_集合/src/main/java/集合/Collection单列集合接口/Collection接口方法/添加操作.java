package 集合.Collection单列集合接口.Collection接口方法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class 添加操作 {
    @Test
    public void test() {
        // add(Object obj)：添加单个数据，结果返回布尔值
        Collection arrayList = new ArrayList();
        arrayList.add("AA");
        arrayList.add(123);
        System.out.println(arrayList);// [AA, 123]

        // addAll()：批量添加
        Collection newArrayList = new ArrayList();
        newArrayList.addAll(arrayList);
        System.out.println(newArrayList);// [AA, 123]
    }
}

