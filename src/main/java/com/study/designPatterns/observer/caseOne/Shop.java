package main.java.com.study.designPatterns.observer.caseOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/6/14 9:29
 * @description: 定义商家
 */
public class Shop {
    //商品
    private String product;

    //持有买家的引用
    private List<Buyer> buyers;

    //初始商店无货
    public Shop() {
        this.product = "无商品";
        this.buyers = new ArrayList<>();
    }

    //出货
    public String getProduct() {
        return product;
    }

    //进货
    public void setProduct(String product) {
        this.product = product;
        //进货以后通知买家
        notifyBuyers();
    }

    //为了主动通知买家，买家得先注册
    public void regesiter(Buyer buyer) {
        this.buyers.add(buyer);
    }

    //通知所有注册的买家
    public void notifyBuyers() {
        buyers.stream().forEach(b -> b.inform());
    }
}
