package main.java.com.study.designPatterns.chain.demoThree;

/**
 * @author: whb
 * @date: 2019/9/5 21:09
 * @description: 数据逻辑检查的职责对象
 */
public class SaleLogicCheck extends SaleHandler {
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //进行数据的逻辑检查，比如检查ID的唯一性，主外键的对应关系等等
        //这里应该检查这种主外键的对应关系，比如销售商品是否存在
        //为了演示简单，直接通过吧

        //如果通过了上面的检测，那就向下继续执行
        return this.successor.sale(user, customer, saleModel);
    }
}
