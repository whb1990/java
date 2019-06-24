package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 16:08
 * @description: 米币支付
 */
public class MiCoinFilter implements PayFilter {

    private static final int canAmount = 10;


    @Override
    public void doPay(int payAmount, PayFilterChain chain) {
        if (payAmount <= canAmount) {
            System.out.println("支付结束，米币支付：【" + payAmount + "】元。");
        } else {
            System.out.println("米币支付10元，剩余：【" + (payAmount - canAmount) + "】元由下一渠道处理");
            chain.doPay((payAmount - canAmount), chain);
        }
    }
}
