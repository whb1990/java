package main.java.com.study.designPatterns.observer.caseOne;

/**
 * @author: whb
 * @date: 2019/6/14 9:45
 * @description: 疯狂买家
 */
public class HandChopper extends Buyer {


    public HandChopper(String name, Shop shop) {
        super(name, shop);
    }

    @Override
    public void inform() {
        String product = shop.getProduct();
        System.out.println(name + "购买：" + product);
    }
}
