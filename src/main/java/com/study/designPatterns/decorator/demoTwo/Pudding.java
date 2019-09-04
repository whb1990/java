package main.java.com.study.designPatterns.decorator.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/4 17:45
 * @description: 布丁奶茶（装饰器）
 */
public class Pudding extends MilkTeaMaterial {

    public Pudding(DrinkMiklTea drinkMiklTea) {
        super(drinkMiklTea);
    }

    @Override
    public BigDecimal getTotalPrice() {
        //在父类基础上价格+2
        return super.getTotalPrice().add(new BigDecimal("2")).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String useMaterial() {
        //在父类的材料基础上+布丁
        return super.useMaterial() + " 添加了：布丁";
    }
}
