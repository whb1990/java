package main.java.com.study.designPatterns.observer.caseOne;

/**
 * @author: whb
 * @date: 2019/6/14 9:43
 * @description: 果粉买家
 */
public class PhoneFans extends Buyer {

    public PhoneFans(String name, Shop shop) {
        //调用父类构造器进行构造
        super(name, shop);
    }

    @Override
    public void inform() {
        String product = shop.getProduct();
        if (product.contains("水果手机")) {
            System.out.println(name + "购买：" + product);
        }
    }
}
