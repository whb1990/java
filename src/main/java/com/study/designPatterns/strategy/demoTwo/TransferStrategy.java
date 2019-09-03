package main.java.com.study.designPatterns.strategy.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/3 20:30
 * @description: 换乘策略：票价 = 基本票价 + 其他费用
 */
public class TransferStrategy implements BuyTicket {

    @Override
    public BigDecimal ticketPrice(BigDecimal basicPrice, BigDecimal servicePrice, BigDecimal otherPrice) {
        return basicPrice.add(otherPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
