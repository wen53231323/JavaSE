package 集合.Collection单列集合接口.Collection子接口Set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class 定制排序 {
    //排序—定制排序：按照年龄从大到小排序
    @Test
    public void test() {
        Comparator com = new Comparator() {
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
        };
        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new Student(1001,"小明"));
        treeSet.add(new Student(1002,"小刚"));
        treeSet.add(new Student(1003,"小红"));
        System.out.println(treeSet);//[test{name='c', age=1}, test{name='b', age=2}, test{name='d', age=3}, test{name='a', age=4}, test{name='e', age=5}]
        //遍历
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
