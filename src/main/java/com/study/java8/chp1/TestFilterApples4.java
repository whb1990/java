package main.java.com.study.java8.chp1;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author: whb
 * @date: 2019/10/28 11:25
 * @description: 据颜色、重量筛选复符合条件的苹果
 * 通过stream流的形式
 */
public class TestFilterApples4 {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(
                new Apple("green", 100),
                new Apple("yellow", 165),
                new Apple("red", 80),
                new Apple("green", 150),
                new Apple("brown", 111),
                new Apple("red", 130),
                new Apple("yellow", 176)
        );
        List<Apple> greenList = appleList.stream().filter((Apple apple) -> "green".equals(apple.getColor())).collect(toList());
        for (Apple apple : greenList) {
            System.out.println("color：" + apple.getColor() + "  weight：" + apple.getWeight());
        }
        List<Apple> havyList = appleList.stream().filter((Apple apple) -> apple.getWeight() >= 150).collect(toList());
        for (Apple apple : havyList) {
            System.out.println("color：" + apple.getColor() + "  weight：" + apple.getWeight());
        }
    }
}
