package main.java.com.study.designPatterns.chain.demoThree;

/**
 * @author: whb
 * @date: 2019/9/5 21:10
 * @description: 真正的业务处理的职责对象
 */
public class SaleMgr extends SaleHandler {
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //进行真正的业务逻辑处理
        System.out.println(user + "保存了" + customer + "购买 " + saleModel + " 的销售数据");
        return true;
    }
}
