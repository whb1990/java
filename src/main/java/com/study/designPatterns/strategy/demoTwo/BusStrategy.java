package main.java.com.study.designPatterns.strategy.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/3 20:28
 * @description: 大巴策略：由于时间较长，除了基本的票价和服务费，还需要购买各种小吃零食辣条等食品来打发冗余的旅途生涯，
 * 因此票价 = 基本票价 + 服务费 + 其他费用
 */
public class BusStrategy implements BuyTicket {

    @Override
    public BigDecimal ticketPrice(BigDecimal basicPrice, BigDecimal servicePrice, BigDecimal otherPrice) {
        return basicPrice.add(servicePrice).add(otherPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
