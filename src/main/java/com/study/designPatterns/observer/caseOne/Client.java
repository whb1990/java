package main.java.com.study.designPatterns.observer.caseOne;

/**
 * @author: whb
 * @date: 2019/6/14 9:35
 * @description: 测试类
 */
public class Client {

    public static void main(String[] args) {
        /*Shop shop = new Shop();
        Buyer wukong = new Buyer("悟空", shop);
        Buyer bajie = new Buyer("八戒", shop);
        Buyer shaseng = new Buyer("沙僧", shop);

        wukong.buy();
        bajie.buy();
        shaseng.buy();
        //唐僧加入购买
        Buyer tangseng = new Buyer("唐僧", shop);
        tangseng.buy();

        //除了八戒，其他人都放弃了
        bajie.buy();
        bajie.buy();

        //商家进货
        shop.setProduct("苹果X");
        bajie.buy();*/

        Shop shop = new Shop();
        Buyer tanSir = new PhoneFans("果粉唐僧",shop);
        Buyer barJeet = new HandChopper("剁手族八戒",shop);
        shop.regesiter(tanSir);
        shop.regesiter(barJeet);

        //商店进货
        shop.setProduct("猪肉炖粉条");
        shop.setProduct("水果手机【爱疯X】");


    }
}
