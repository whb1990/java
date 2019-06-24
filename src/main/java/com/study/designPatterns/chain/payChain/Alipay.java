package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 15:35
 * @description: 支付宝支付
 */
public class Alipay extends Payment {

    public Alipay(String name, int amount) {
        super(name, amount);
    }

    @Override
    public void pay(int amount) {
        if (amount <= 5) {
            System.out.println("支付成功，支付方式：【" + name + "】，支付金额：【" + amount + "】元");
        } else {
            System.out.println("余额不足，还有：【" + (amount - 5) + "】元未支付");
        }
    }
}
