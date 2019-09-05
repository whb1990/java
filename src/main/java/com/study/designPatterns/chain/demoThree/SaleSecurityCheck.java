package main.java.com.study.designPatterns.chain.demoThree;

/**
 * @author: whb
 * @date: 2019/9/5 21:08
 * @description: 具体职责对象--安全检查的职责对象
 */
public class SaleSecurityCheck extends SaleHandler {
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //进行权限检查，简单点，就小李能通过
        if ("小李".equals(user)) {
            return this.successor.sale(user, customer, saleModel);
        } else {
            System.out.println("对不起" + user + "，你没有保存销售信息的权限");
            return false;
        }
    }
}
