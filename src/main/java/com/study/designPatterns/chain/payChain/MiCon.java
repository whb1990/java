package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 15:00
 * @description: 米币支付
 */
public class MiCon extends Payment {

    public MiCon(String name, int amount) {
        super(name, amount);
    }

    @Override
    public void pay(int amount) {
        if (amount <= 10) {
            System.out.println("支付成功，支付方式【" + name + "】，支付金额：【" + amount + "】元");
        } else {
            System.out.println(name + "支付了10元，剩余：" + (amount - 10) + "交给下一个渠道处理");
            setNextPayment(new Wechat("微信", (amount - 10))).pay(amount - 10);
        }
    }
}
