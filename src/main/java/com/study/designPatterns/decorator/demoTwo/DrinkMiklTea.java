package main.java.com.study.designPatterns.decorator.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/4 17:37
 * @description: 抽象组件-喝奶茶接口
 */
public interface DrinkMiklTea {
    /**
     * 计算一杯奶茶的价格
     */
    BigDecimal getTotalPrice();

    /**
     * 奶茶使用的材料
     */
    String useMaterial();
}
