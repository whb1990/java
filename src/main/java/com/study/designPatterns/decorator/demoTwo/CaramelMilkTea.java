package main.java.com.study.designPatterns.decorator.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/4 17:44
 * @description: 定义一个焦糖奶茶去实现顶层接口
 * 本质就是核心组件（青稞、布丁等材料必须依附这个组件才有意义）
 */
public class CaramelMilkTea implements DrinkMiklTea {

    @Override
    public BigDecimal getTotalPrice() {
        return new BigDecimal("12");
    }

    @Override
    public String useMaterial() {
        return "焦糖奶茶";
    }
}
