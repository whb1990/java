package main.java.com.study.designPatterns.strategy.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/3 20:27
 * @description: 黄牛策略：票价 = 基本票价 + 服务费
 */
public class ScalpersStrategy implements BuyTicket {

    @Override
    public BigDecimal ticketPrice(BigDecimal basicPrice, BigDecimal servicePrice, BigDecimal otherPrice) {
        return basicPrice.add(servicePrice).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
