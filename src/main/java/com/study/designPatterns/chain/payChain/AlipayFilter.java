package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 16:09
 * @description:支付宝支付
 */
public class AlipayFilter implements PayFilter {

    private static final int canAmount = 5;

    @Override
    public void doPay(int payAmount, PayFilterChain chain) {
        if (payAmount <= canAmount) {
            System.out.println("支付结束，支付宝支付：【" + payAmount + "】元。");
        } else {
            System.out.println("支付宝支付5元，剩余：【" + (payAmount - canAmount) + "】元因余额不足无法支付。");
        }
    }
}
