package com.wen.stream流.流操作链;

import com.wen.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class 中间操作链_2_映射 {

    // 静态方法，用来返回 列表中列表 [[1,2,3],[1,2,3]]
    private static List<List<Integer>> getList() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(integers);
        lists.add(integers);
        return lists;
    }

    /**
     * map(Function f)：对流中每一个元素进行处理
     * 接受一个函数作为参数，这个函数会被应用到每个元素上，并将其映射成一个新的元素
     * 案例：将集合中的小写字符串转为大小
     */
    @Test
    public void test1() {
        List<String> arrayList = Arrays.asList("a", "b", "c");
        arrayList.stream().map(str -> str.toUpperCase()).forEach(System.out::print);
    }

    /**
     * flatMap(Function f)：流扁平化，将一个整体拆成一个一个的个体，称为扁平化（拆分层级，放到同一层）
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 案例1：拆分 ["Hello", "World"] 为 HelloWorld
     */
    @Test
    public void test2() {
        String[] words = new String[]{"Hello", "World"};// ["Hello", "World"]
        Arrays.stream(words)
                .map(str -> str.split("")) // 按空格分隔字符，形成多个字符（H e l l o W o r l d）
                .flatMap(
                        Arrays::stream // 获取内层数组的流对象
                )// 生成的多个流被合并起来，即扁平化为一个流
                .forEach(System.out::print);// 输出HelloWorld
    }

    /**
     * flatMap(Function f)：流扁平化，将一个整体拆成一个一个的个体，称为扁平化（拆分层级，放到同一层）
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 案例2：拆分 [[1,2,3],[1,2,3]] 为 123123
     */
    @Test
    public void test3() {
        List<List<Integer>> lists = getList();// [[1,2,3],[1,2,3]]
        lists.stream()
                .flatMap(
                        item -> item.stream()// 获取内层数组的流对象
                )// 将多个流扁平化为一个流
                .forEach(System.out::print);
    }

    /**
     * flatMap(Function f)：流扁平化，将一个整体拆成一个一个的个体，称为扁平化（拆分层级，放到同一层）
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 案例3：拆分 用户集合列表 获取 集合中数组中的数据
     */
    @Test
    public void test4() {
        List<User> userList = User.getUserList();
        userList.stream()
                .flatMap(
                        user -> user.getHobby().stream() // 获取数组的流对象
                )// 将多个流扁平化为一个流
                .forEach(System.out::print);
    }

}
