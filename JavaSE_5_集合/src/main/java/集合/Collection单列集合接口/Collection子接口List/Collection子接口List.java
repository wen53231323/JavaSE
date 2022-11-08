package 集合.Collection单列集合接口.Collection子接口List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Collection子接口List {
    @Test
    public void test1(){
        //void add(int index, Object ele):在index位置插入ele元素
        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        ArrayList list1 = new ArrayList();
        list1.add(123);
        list1.add(456);
        list1.add(1,"A");
        System.out.println(list1);//[123, A, 456]

        List arr = Arrays.asList("B","C");
        list1.addAll(2, arr);
        System.out.println(list1);//[123, A, B, C, 456]

        //Object get(int index):获取指定index位置的元素
        //Object set(int index, Object ele):设置指定index位置的元素为ele
        ArrayList list2 = new ArrayList();
        list2.add(123);
        list2.add(45);
        System.out.println(list2.get(0));//123
        list2.set(1,456);
        System.out.println(list2);//[123, 456]

        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在，返回-1
        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        ArrayList list3 = new ArrayList();
        list3.add(123);
        list3.add(456);
        list3.add(123);
        System.out.println(list3.indexOf(123));//0
        System.out.println(list3.indexOf(1234));//-1
        System.out.println(list3.lastIndexOf(123));//2
        System.out.println(list3.lastIndexOf(1234));//-1

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        ArrayList list4 = new ArrayList();
        list4.add(123);
        list4.add(456);
        Object remove = list4.remove(0);
        System.out.println(remove);//123
        System.out.println(list4);//456

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间子集合
        ArrayList list5 = new ArrayList();
        list5.add("A");
        list5.add("B");
        list5.add("C");
        list5.add("D");
        list5.add("E");
        List subList = list5.subList(1, 3);
        System.out.println(subList);//[B, C]
    }
    @Test
    public void test2(){
        ArrayList list5 = new ArrayList();
        list5.add("A");
        list5.add("B");
        list5.add("C");
        //方式一：Iterator迭代器
        Iterator iterator = list5.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //方式二：增强for循环foreach
        for (Object i:list5) {
            System.out.println(i);
        }
        //方式三：普通for循环
        for (int i=0;i<list5.size();i++){
            System.out.println(list5.get(i));
        }

    }
}
