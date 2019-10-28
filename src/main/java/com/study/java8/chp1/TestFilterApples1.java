package main.java.com.study.java8.chp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/10/28 10:58
 * @description: 根据颜色、重量筛选复符合条件的苹果
 * 传统实现方式
 */
public class TestFilterApples1 {

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
        List<Apple> greenList = getGreenApples(appleList);
        for (Apple apple : greenList) {
            System.out.println("color：" + apple.getColor() + "  weight：" + apple.getWeight());
        }
        List<Apple> heavyList = getHeavyApples(appleList);
        for (Apple apple : heavyList) {
            System.out.println("color：" + apple.getColor() + "  weight：" + apple.getWeight());
        }
    }

    /**
     * 筛选绿色的苹果
     *
     * @param appleList
     * @return
     */
    private static List<Apple> getGreenApples(List<Apple> appleList) {
        if (appleList == null || appleList.isEmpty()) {
            return null;
        }
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选重量大于150克的苹果
     *
     * @param appleList
     * @return
     */
    private static List<Apple> getHeavyApples(List<Apple> appleList) {
        if (appleList == null || appleList.isEmpty()) {
            return null;
        }
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (apple.getWeight() >= 150) {
                result.add(apple);
            }
        }
        return result;
    }
}
