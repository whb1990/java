package main.java.com.study.designPatterns.chain.payChain;

/**
 * @author: whb
 * @date: 2019/6/13 14:57
 * @description: 支付对象
 */
public abstract class Payment {

    protected String name;

    protected int amount;

    protected Payment nextPayment;

    public Payment(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Payment setNextPayment(Payment payment) {
        this.nextPayment = payment;
        return this.nextPayment;
    }

    public abstract void pay(int amount);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
