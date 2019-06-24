package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 15:29
 * @description: 微信支付
 */
public class Wechat extends Payment {

    public Wechat(String name, int amount) {
        super(name, amount);
    }

    @Override
    public void pay(int amount) {
        if (amount <= 5) {
            System.out.println("支付成功，支付方式：【" + name + "】，支付金额：【" + amount + "】元");
        } else {
            System.out.println(name + "支付了：5元，剩余：" + (amount - 5) + "元，由下一渠道去支付");
            setNextPayment(new Alipay("支付宝", (amount - 5))).pay(amount - 5);
        }
    }
}
