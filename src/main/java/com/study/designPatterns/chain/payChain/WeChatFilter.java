package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 16:09
 * @description: 微信支付
 */
public class WeChatFilter implements PayFilter {

    private static final int canAmount = 5;

    @Override
    public void doPay(int payAmount, PayFilterChain chain) {
        if (payAmount <= canAmount) {
            System.out.println("支付结束，微信支付：【" + payAmount + "】元。");
        } else {
            System.out.println("微信支付了5元，剩余：【" + (payAmount - canAmount) + "】元，由下一渠道处理。");
            chain.doPay((payAmount - canAmount), chain);
        }
    }
}
