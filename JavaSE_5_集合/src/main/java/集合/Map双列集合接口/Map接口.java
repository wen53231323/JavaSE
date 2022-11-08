package 集合.Map双列集合接口;


import org.junit.Test;
import 集合.Collection单列集合接口.Collection子接口Set.Student;

import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.BlockingDeque;

public class Map接口 {
    @Test
    public void test1() {

        //	Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        Map map1 = new HashMap();
        //添加
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 2);
        //修改
        map1.put("a", 2);
        System.out.println(map1);//{a=2, b=2, c=2}

        //void putAll(Map m):将m中的所有key-value对存放到当前map中
        Map map2 = new HashMap();
        map2.put("d", 2);
        map2.put("e", 2);
        map2.putAll(map1);
        System.out.println(map2);//{a=2, b=2, c=2, d=2, e=2}

        //Object remove(Object key)：移除指定key的key-value对，并返回value
        Map map3 = new HashMap();
        map3.put("a", 1);
        map3.put(1, 1);
        Object remove = map3.remove(1);
        System.out.println(remove);//1
        System.out.println(map3);//{a=1}

        //void clear()：清空当前map中的所有数据
        Map map4 = new HashMap();
        map4.put("a", 1);
        map4.put("b", 2);
        System.out.println(map4);//{a=1, b=2}
        map4.clear();
        System.out.println(map4);//{}

    }

    @Test
    public void test2() {
        //Object get(Object key)：获取指定key对应的value
        //boolean containsKey(Object key)：是否包含指定的key
        //boolean containsValue(Object value)：是否包含指定的value
        //int size()：返回map中key-value对的个数
        //boolean isEmpty()：判断当前map是否为空
        //boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        //添加
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        System.out.println(map1.get("a"));//1
        System.out.println(map1.containsKey("d"));//false
        System.out.println(map1.containsValue(2));//true
        System.out.println(map1.size());//3
        System.out.println(map1.isEmpty());//false
        System.out.println(map1.equals(map2));//false
    }

    @Test
    public void test3() {
        //Set keySet()：返回所有key构成的Set集合
        //Collection values()：返回所有value构成的Collection集合
        //Set entrySet()：返回所有key-value对构成的Set集合
        Map map1 = new HashMap();
        //添加
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        //遍历所有的key集
        Set set = map1.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //用增强for循环遍历
        for (Object v : set) {
            System.out.println(v);
        }

        //遍历所有的value集
        Collection values = map1.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        //用增强for循环遍历
        for (Object v : values) {
            System.out.println(v);
        }

        //遍历所有的key-value
        //方式一：
        Set entrySets = map1.entrySet();
        Iterator iterator2 = entrySets.iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "—>" + entry.getValue());
        }
        //方式二：
        Set set2 = map1.keySet();
        Iterator iterator3 = set2.iterator();
        while (iterator3.hasNext()) {
            Object key = iterator3.next();
            Object value = map1.get(key);
            System.out.println(key + "—>" + value);
        }
    }

    //排序—自然排序
    @Test
    public void test4() {
        TreeMap treeMap = new TreeMap();
        treeMap.put(new Student(1001, "小明"), 1);
        treeMap.put(new Student(1002, "小刚"), 2);
        treeMap.put(new Student(1003, "小红"), 3);
        Set entrySets = treeMap.entrySet();
        Iterator iterator2 = entrySets.iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "—>" + entry.getValue());
        }
    }

    //排序—定制排序：按照年龄从大到小排序
    @Test
    public void test5() {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    Student t1 = (Student) o1;
                    Student t2 = (Student) o2;
                    return Integer.compare(t1.getId(), t2.getId());
                } else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        });
        treeMap.put(new Student(1001, "小明"), 1);
        treeMap.put(new Student(1002, "小刚"), 2);
        treeMap.put(new Student(1003, "小红"), 3);
        Set entrySets = treeMap.entrySet();
        Iterator iterator2 = entrySets.iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "—>" + entry.getValue());
        }
    }

    @Test
    public void test6() throws Exception {
        //Properties()：用来读取配置文件
        Properties properties = new Properties();
        //加载配置文件（配置文件名后缀为.properties）
        FileInputStream f = new FileInputStream("src/集合/test.properties");
        properties.load(f);//加载配置文件

        String name = properties.getProperty("name");
        System.out.println(name);
        String password = properties.getProperty("password");
        System.out.println(password);
    }
}
