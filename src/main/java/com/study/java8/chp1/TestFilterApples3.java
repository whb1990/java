package main.java.com.study.java8.chp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: whb
 * @date: 2019/10/28 11:23
 * @description: 据颜色、重量筛选复符合条件的苹果
 * 不需要定义方法
 */
public class TestFilterApples3 {
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
        List<Apple> greenList = filtersApple(appleList, (Apple apple) -> "green".equals(apple.getColor()));
        for (Apple apple : greenList) {
            System.out.println("color：" + apple.getColor() + "  weight：" + apple.getWeight());
        }
        List<Apple> heavyList = filtersApple(appleList, (Apple apple) -> apple.getWeight() >= 150);
        for (Apple apple : heavyList) {
            System.out.println("color：" + apple.getColor() + "  weight：" + apple.getWeight());
        }
    }

    /**
     * 过滤符合条件的苹果
     *
     * @param appleList
     * @param p
     * @return
     */
    private static List<Apple> filtersApple(List<Apple> appleList, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
