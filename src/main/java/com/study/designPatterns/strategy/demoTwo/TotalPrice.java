package main.java.com.study.designPatterns.strategy.demoTwo;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/9/3 20:32
 * @description: 计算策略的费用
 */
public class TotalPrice {

    public BuyTicket buyTicket;

    public TotalPrice(BuyTicket buyTicket) {
        this.buyTicket = buyTicket;
    }

    /**
     * 计算票价
     *
     * @param basicPrice
     * @param servicePrice
     * @param otherPrice
     * @return
     */
    public BigDecimal addPrice(BigDecimal basicPrice, BigDecimal servicePrice, BigDecimal otherPrice) {
        return buyTicket.ticketPrice(basicPrice, servicePrice, otherPrice);
    }
}
