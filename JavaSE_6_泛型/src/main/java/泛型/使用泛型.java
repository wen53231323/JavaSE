package 泛型;

import org.junit.Test;

import java.util.*;

public class 使用泛型 {
    @Test
    public void test1() {
        // 需求：不使用泛型，将学生成绩存入集合
        ArrayList arrayList = new ArrayList();
        arrayList.add(70);
        arrayList.add(80);
        arrayList.add(90);
        // 问题一：类型不安全，此时编译不出异常，但是不是需要存储的数据
        arrayList.add("小明");

        // 遍历集合
        for (Object o : arrayList) {
            // 问题二：强转时可能出现ClassCastException（类型转换异常）
            // 由于需要强转成int型输出成绩，一旦出现了其他数据类型的数据就会强转出错
            int results = (Integer) o;
            System.out.println(results);
        }
    }

    @Test
    public void test2() {
        // 需求：使用泛型，将学生成绩存入集合
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(70);
        arrayList.add(80);
        arrayList.add(90);
        // 此时编译非int时会报异常，保证了数据安全
        // arrayList.add("小明");

        // 遍历集合
        for (Integer i : arrayList) {
            // 此时不用强转就可以遍历
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        //泛型嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        //遍历
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry1 = iterator.next();
            String key = entry1.getKey();
            Integer value = entry1.getValue();
            System.out.println("key：" + key + "  " + "value：" + value);
            System.out.println("entry：" + entry1);
        }
    }
}


