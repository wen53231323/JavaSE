package 集合.Collection单列集合接口.Collection子接口Set;

import org.junit.Test;

import java.util.*;

public class Collection子接口Set {
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("C");
        System.out.println(set);//[A, B, C, 123]

        Set set1 = new LinkedHashSet();
        set1.add(123);
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("C");
        System.out.println(set1);//[123, A, B, C]
    }

    @Test
    public void test2() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(-3);
        treeSet.add(0);
        System.out.println(treeSet);//[-3, 0, 2, 3, 4]
        //遍历
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
