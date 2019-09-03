package main.java.com.study.designPatterns.strategy.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/3 20:33
 * @description: 客户端调用
 * A：大巴基本票价：500 服务费：100 其他费用：60
 * <p>
 * B：黄牛票价：463 服务费：150
 * <p>
 * C：换乘票价：480 其他费用：200
 */
public class Client {

    public static void main(String[] args) {
        TotalPrice busPrice = new TotalPrice(new BusStrategy());
        TotalPrice scalperPrice = new TotalPrice(new ScalpersStrategy());
        TotalPrice transferPrice = new TotalPrice(new TransferStrategy());

        //大巴基本票价：500 服务费：100 其他费用：60
        BigDecimal bus = busPrice.addPrice(new BigDecimal("500"), new BigDecimal("100"), new BigDecimal("60"));
        //黄牛票价：463 服务费：150
        BigDecimal scalper = scalperPrice.addPrice(new BigDecimal("463"), new BigDecimal("150"), BigDecimal.ZERO);
        //换乘票价：480 其他费用：200
        BigDecimal transfer = transferPrice.addPrice(new BigDecimal("480"), BigDecimal.ZERO, new BigDecimal("200"));

        System.out.println("大巴策略的总费用：" + bus.toString());
        System.out.println("黄牛策略的总费用：" + scalper.toString());
        System.out.println("换乘策略的总费用：" + transfer.toString());
    }
}
