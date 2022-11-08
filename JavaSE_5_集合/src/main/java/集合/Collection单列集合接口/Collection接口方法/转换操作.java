package 集合.Collection单列集合接口.Collection接口方法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class 转换操作 {
    @Test
    public void test() {
        Collection arrayList = new ArrayList();
        arrayList.add("AA");
        arrayList.add("BB");
        arrayList.add("CC");
        System.out.println(arrayList);// [AA, BB, CC]

        // toArray()：集合 —> 数组，正确的顺序返回一个包含此列表中所有元素的数组（从第一个到最后一个元素）
        Object[] arr = arrayList.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 扩展：数组 —> 集合，调用Arrays类的静态方法asList()创建集合
        Collection<String> asList = Arrays.asList("AA", "BB", "CC");
        System.out.println(asList);// [AA, BB, CC]
    }
}
