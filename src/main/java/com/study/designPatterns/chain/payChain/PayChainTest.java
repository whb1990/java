package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 15:40
 * @description: 支付链测试
 */
public class PayChainTest {

    public static void main(String[] args) {
        Payment payment = new MiCon("米币", 0);
        payment.setNextPayment(new Wechat("微信", 0)).setNextPayment(new Alipay("支付宝", 0));
        payment.pay(22);
    }
}
