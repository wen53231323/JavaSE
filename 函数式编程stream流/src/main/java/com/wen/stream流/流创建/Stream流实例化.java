package com.wen.stream流.流创建;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream流实例化 {
    /**
     * 通过集合创建Stream流（最常用）
     * Java8 中的 Collection 接口被扩展，提供了两个获取流的方法：
     * default Stream<E> stream() : 返回一个顺序流
     * default Stream<E> parallelStream() : 返回一个并行流
     */
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        // 根据集合创建顺序流
        Stream stream1 = list.stream();
        // 根据集合创建并行流
        Stream stream2 = list.parallelStream();
    }

    /**
     * 通过数组创建Stream流
     * Java8 中的 Arrays 的静态方法 stream() 可以获取数组流
     * static <T> Stream<T> stream(T[] array): 返回一个流
     */
    @Test
    public void test2() {
        int[] ints = {};
        // 根据int数组创建流
        IntStream stream = Arrays.stream(ints);
    }

    /**
     * 通过Stream本身创建Stream流
     * 调用Stream类静态方法 of(),通过显示值创建一个流,可以接收任意数量的参数
     * public static<T> Stream<T> of(T... values) : 返回一个流
     */
    @Test
    public void test3() {
        // 通过Stream本身创建Stream流
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    /**
     * 通过函数创建Stream无限流
     * 使用静态方法 Stream.iterate() 和 Stream.generate()创建无限流
     * 迭代：iterate方法参数一初始化值，参数二为进行的函数操作
     * public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
     * 生成：
     * public static<T> Stream<T> generate(Supplier<T> s)
     */
    @Test
    public void test4() {
        // 迭代
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        // 生成
        Stream<Double> generate = Stream.generate(Math::random);

    }

    /**
     * 通过文件创建Stream流
     * 通过Files.line方法得到一个流，并且得到的每个流是给定文件中的一行
     */
    @Test
    public void test5() {
        try {
            Stream<String> fileStream = Files.lines(Paths.get("test.txt"), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
