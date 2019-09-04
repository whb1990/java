package main.java.com.study.designPatterns.decorator.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/4 17:48
 * @description: 青稞奶茶
 */
public class HighlandBarley extends MilkTeaMaterial {

    public HighlandBarley(DrinkMiklTea drinkMiklTea) {
        super(drinkMiklTea);
    }

    @Override
    public BigDecimal getTotalPrice() {
        //在父类基础上价格+3
        return super.getTotalPrice().add(new BigDecimal("3")).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String useMaterial() {
        //在父类的材料基础上+青稞
        return super.useMaterial() + " 添加了：青稞";
    }
}
