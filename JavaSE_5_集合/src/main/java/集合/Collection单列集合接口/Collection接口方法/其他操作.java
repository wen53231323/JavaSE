package 集合.Collection单列集合接口.Collection接口方法;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class 其他操作 {
    @Test
    public void test() {
        Collection<String> asList = Arrays.asList("AA", "BB", "CC");
        List<String> collect1 = asList.stream().collect(Collectors.toList());
        System.out.println(collect1);// [AA, BB, CC]
        List<String> collect2 = asList.parallelStream().collect(Collectors.toList());
        System.out.println(collect2);// [AA, BB, CC]
    }
}
