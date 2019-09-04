package main.java.com.study.designPatterns.decorator.demoTwo;

import java.math.BigDecimal;
import java.nio.file.DirectoryStream;

/**
 * @author: whb
 * @date: 2019/9/4 17:39
 * @description: 一杯奶茶具体会使用什么材料，这个不清楚（材料可以设计成布丁、青稞等），
 * 因此将附加的材料单独抽取出来，设计成一个抽象类，让子类去定义具体的材料。
 * 但是单独定义没有任何意义，需要将材料放进奶茶才能体现价值，因此需要实现顶层的奶茶接口。
 */
public abstract class MilkTeaMaterial implements DrinkMiklTea {

    /**
     * 将顶层接口以构造参数的方式传递进来
     */
    private DrinkMiklTea drinkMiklTea;

    public MilkTeaMaterial(DrinkMiklTea drinkMiklTea) {
        this.drinkMiklTea = drinkMiklTea;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return drinkMiklTea.getTotalPrice();
    }

    @Override
    public String useMaterial() {
        return drinkMiklTea.useMaterial();
    }
}
