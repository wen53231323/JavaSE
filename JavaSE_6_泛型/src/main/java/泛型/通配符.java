package 泛型;

import org.junit.Test;

import java.util.ArrayList;

import java.util.List;

public class 通配符 {
    @Test
    public void test(){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("B");
        //List<?>是List<String>、List<Object>等各种泛型List的父类。
        List<?> list;
        list=list1;
        list=list2;

        //添加(写入)：对于List<?>不能向内部添加数据，除了添加null
        //list.add("A");
        list.add(null);

        //获取(读取)：允许读取数据，类型是Object
        Object o = list.get(0);
        System.out.println(o);

    }

}
