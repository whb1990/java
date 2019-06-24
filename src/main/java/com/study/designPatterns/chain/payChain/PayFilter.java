package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 16:06
 * @description: 支付链
 */
public interface PayFilter {

    /**
     * 支付
     *
     * @param payAmount 待付金额
     * @param chain     支付链
     */
    void doPay(int payAmount, PayFilterChain chain);
}
