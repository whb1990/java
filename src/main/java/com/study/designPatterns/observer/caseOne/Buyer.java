package main.java.com.study.designPatterns.observer.caseOne;

/**
 * @author: whb
 * @date: 2019/6/14 9:33
 * @description: 定义买家
 */
public abstract class Buyer {
    //买家姓名
    protected String name;
    //商店引用
    protected Shop shop;

    public Buyer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
        //shop.regesiter(this);
    }

    //买家购买
    public void buy() {
        System.out.println(name + "购买：" + shop.getProduct());
    }

    public abstract void inform();
}
