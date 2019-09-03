package main.java.com.study.designPatterns.strategy.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/3 20:25
 * @description: 购票策略行为接口
 */
public interface BuyTicket {

    /**
     * 票价
     *
     * @param basicPrice   基本费用
     * @param servicePrice 服务费用
     * @param otherPrice   其他费用
     * @return
     */
    BigDecimal ticketPrice(BigDecimal basicPrice, BigDecimal servicePrice, BigDecimal otherPrice);
}
