package main.java.com.study.designPatterns.builder.demoTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/9/5 14:01
 * @description: 定义产品：电脑
 */
public class Computer {
    /**
     * 电脑组件的集合
     */
    private List<String> parts = new ArrayList<String>();

    /**
     * 用于将组件组装到电脑里
     *
     * @param part
     */
    public void add(String part) {
        parts.add(part);
    }

    /**
     * 展示组装结果
     */
    public void show() {
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("组件" + parts.get(i) + "装好了");
        }
        System.out.println("电脑组装完成，请验收");
    }
}
