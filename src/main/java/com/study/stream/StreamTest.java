package main.java.com.study.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: whb
 * @date: 2019/6/12 14:23
 * @description: jdk1.8的stream类
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("12345");
        list.add("xyz");
        list.add("1234");
        list.add("1221");
        list.add("efgh");
        list.add("uide");
        //通过集合创建stream
        List<String> listResult = list.stream()
                .filter(item -> item.length() == 4)
                .filter(item -> item.charAt(0) >= 'a' && item.charAt(0) <= 'z')
                .collect(Collectors.toList());
        System.out.println(listResult.toString());
        //通过数组方式创建stream
        Stream<String> arrayStream = Arrays.stream(new String[]{"abcd", "12345", "xyz", "1234", "1221", "efgh", "uide"});
        List<String> arrayResult = arrayStream.filter(item -> item.length() == 4)
                .filter(item -> item.charAt(0) >= 'a' && item.charAt(0) <= 'z')
                .collect(Collectors.toList());
        System.out.println(arrayResult.toString());
        //创建一个空的stream
        Stream<String> emptyStream = Stream.empty();
        List<String> emptyResult = emptyStream.collect(Collectors.toList());
        System.out.println(emptyResult.toString());
        //创建无限元素个数的stream
        Stream<Long> unlimitedStream = Stream.generate(() -> (new Random().nextLong()));
        List<Long> unlimitedResult = unlimitedStream.limit(100).collect(Collectors.toList());
        System.out.println(unlimitedResult.toString());
        //创建有规律的无限流
        Stream<Long> stream = Stream.iterate(0L, item -> item + 1L);
        List<Long> result2 = stream.limit(100).collect(Collectors.toList());
        System.out.println(result2.toString());
    }

}
