package 集合.Collection单列集合接口;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Collections工具类 {
    @Test
    public void test1(){
        List arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(0);
        arrayList.add(-2);
        arrayList.add(1);
        arrayList.add(-1);
        System.out.println(arrayList);//[2, 0, -2, 1, -1]
        //反转
        Collections.reverse(arrayList);
        System.out.println(arrayList);//[-1, 1, -2, 0, 2]
        //随机排序
        Collections.shuffle(arrayList);
        System.out.println(arrayList);//[0, 2, -2, 1, -1]（随机的）
        //升序排序
        Collections.sort(arrayList);
        System.out.println(arrayList);//[-2, -1, 0, 1, 2]
        //交换指定索引的元素
        Collections.swap(arrayList,0,1);
        System.out.println(arrayList);//[-1, -2, 0, 1, 2]

        //复制
        List objects = Arrays.asList(new Object[arrayList.size()]);
        Collections.copy(objects,arrayList);
        System.out.println(objects);//[-1, -2, 0, 1, 2]

        //解决线程安全问题：
        //此时返回的list是线程安全的
        List list = Collections.synchronizedList(arrayList);



    }

}
