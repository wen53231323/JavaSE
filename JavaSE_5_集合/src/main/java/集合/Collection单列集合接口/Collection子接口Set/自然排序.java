package 集合.Collection单列集合接口.Collection子接口Set;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class 自然排序 {
    //排序—自然排序
    @Test
    public void test() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Student(1001,"小明"));
        treeSet.add(new Student(1002,"小刚"));
        treeSet.add(new Student(1003,"小红"));
        System.out.println(treeSet);// [Student{id=1002, name='小刚'}, Student{id=1001, name='小明'}, Student{id=1003, name='小红'}]
        // 遍历
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
